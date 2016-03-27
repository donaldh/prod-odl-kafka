/*
 * [To Do: Use OpenDayLight licence]
 */
package org.opendaylight.kafkacluster.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.opendaylight.controller.md.sal.dom.api.DOMNotification;
import org.opendaylight.controller.md.sal.dom.api.DOMNotificationListener;
import org.opendaylight.controller.md.sal.dom.api.DOMNotificationService;
import org.opendaylight.yang.gen.v1.urn.cisco.params.xml.ns.yang.messagebus.eventaggregator.rev141202.TopicId;
import org.opendaylight.yang.gen.v1.urn.cisco.params.xml.ns.yang.messagebus.eventaggregator.rev141202.TopicNotification;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev160323.KafkaProducerConfig;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev160323.KafkaProducerConfig.CompressionType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev160323.KafkaProducerConfig.MessageSerialization;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev160323.KafkaProducerConfig.KafkaProducerType;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.data.api.YangInstanceIdentifier.NodeIdentifier;
import org.opendaylight.yangtools.yang.data.api.schema.AnyXmlNode;
import org.opendaylight.yangtools.yang.model.api.SchemaPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * @author Xiaoyu Chen
 */
public class KafkaUserAgentImpl implements DOMNotificationListener, AutoCloseable {

    
    //static variables 
    private final static Logger LOG = LoggerFactory.getLogger(KafkaUserAgentImpl.class);
    private final static String avroSchema = "record.avsc";
    private static Schema schema;
    
    //Private variables
    private final ListenerRegistration<KafkaUserAgentImpl> notificationReg;
    private final NodeIdentifier EVENT_SOURCE_NODE = new NodeIdentifier(QName.create(TopicNotification.QNAME, "node-id"));
    private final NodeIdentifier PAYLOAD_NODE = new NodeIdentifier(QName.create(TopicNotification.QNAME, "payload"));
    private static final NodeIdentifier TOPIC_ID_ARG = new NodeIdentifier(QName.create(TopicNotification.QNAME, "topic-id"));
    private final SchemaPath TOPIC_NOTIFICATION_PATH = SchemaPath.create(true, TopicNotification.QNAME);
    private final String DEFAULT_HOST_IP;
    private final KafkaProducer producer;
    private final String timestampXPath;
    private final String hostIpXPath;
    private final String messageSourceXPath;
    private final String defaultMessageSource;
    private final String topic;
    private final Set<String> registeredTopics = new HashSet<>();

    
    
    //Public methods --
    
    
    /**
     * Static factory method
     * @param notificationService
     * @param configuration
     * @return Singleton instance of KafkaUserAgentImpl
     */
    public static KafkaUserAgentImpl create(final DOMNotificationService notificationService, final KafkaProducerConfig configuration) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("in create()");
        }
        return new KafkaUserAgentImpl(notificationService, configuration);
    }

    /**
     * Handling notifications received via ODL message bus
     * @param notification 
     */
    @Override
    public void onNotification(DOMNotification notification) {
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("in onNotification()");
        }

        LOG.info("Notification received.");
        
        boolean isAcceptable = false;
        
        if (registeredTopics.isEmpty())
        {
            isAcceptable=true;
        }
        
        if (!isAcceptable)
        {
            LOG.info("topic filters are not empty; applying them now...");
            //check topic against filter list
            if(notification.getBody().getChild(TOPIC_ID_ARG).isPresent()){
                TopicId topicId = (TopicId) notification.getBody().getChild(TOPIC_ID_ARG).get().getValue();
                if (topicId != null)
                {
                    LOG.info("topic is parsed: " + topicId.getValue());
                    if(registeredTopics.contains(topicId.getValue())){
                        isAcceptable = true;
                        LOG.info("Topic accepted.");
                    }
                }
            }
        }
        
        try{
            
            if (producer!=null && isAcceptable)
            {
                String messageSource=null;
                Long timestamp = null;
                String hostIp=null;

                //processing message
                
                final String rawdata = this.parsePayLoad(notification);
                
                if (messageSourceXPath != null)
                {
                    LOG.info("evaluating " + messageSourceXPath + " against message payload...");
                    messageSource = this.evaluate(rawdata, messageSourceXPath);
                }
                
                if (messageSource == null)
                {
                    messageSource = this.defaultMessageSource;
                }
                
                if (messageSource == null)
                {
                    LOG.info("no message source xpath specified or invalid xpath statement. Use the node-id by default.");
                    final String nodeId = notification.getBody().getChild(EVENT_SOURCE_NODE).get().getValue().toString();
                    messageSource = nodeId;
                }
                
                LOG.info("src = " + messageSource);

                if (timestampXPath != null)
                {
                    LOG.info("evaluating " + timestampXPath + " against message payload ...");
                    timestamp = Long.valueOf(this.evaluate(rawdata, timestampXPath));
                    
                }
                
                if (timestamp == null)
                {
                    LOG.info("no timestampe xpath specified or invalid xpath statement. Use the system time by default");
                    timestamp = System.currentTimeMillis();
                }
                
                LOG.info("timestamp = " + timestamp);

                
                if (hostIpXPath != null)
                {
                    LOG.info("evaluating " + hostIpXPath + " against message payload ...");
                    hostIp = this.evaluate(rawdata, hostIpXPath);
                }
                
                if (hostIp == null)
                {
                    LOG.info("not host ip xpath specified, use the ODL host ip by default");
                    hostIp = DEFAULT_HOST_IP;
                    
                }
                LOG.info("host-ip = " + hostIp);
                

                LOG.info("about to send message to Kafka ...");
                ProducerRecord<String, byte[]> message;
                if (schema == null)
                {
                    LOG.info("sending data without serialization.");
                    message = new ProducerRecord<>(topic, rawdata.getBytes());
                }
                else
                {
                    LOG.info("sending data using avro serialisation.");
                    message = new ProducerRecord<>(topic, encode(timestamp, hostIp, messageSource, rawdata));
                }
                producer.send(message);
                LOG.info("message sent.");
            }
        }catch(Exception ex)
        {
            LOG.error("Error while sending message to Kafka: ", ex);
        }
    }

    /**
     * Stop kafka agent 
     * @throws Exception 
     */
    @Override
    public void close() throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("in close()");
        }
        //unregister notification handler
        notificationReg.close();
        
        //stop kafka producer 
        producer.close();
    }
    
    //Private methods --
    
    /**
     * Constructor
     * @param notificationService
     * @param configuration 
     */
    private KafkaUserAgentImpl(final DOMNotificationService notificationService, final KafkaProducerConfig configuration) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("in KafkaUserAgentImpl()");
        }

        LOG.info("registering to Notification Service broker");
        //register this as a listener to notification service and listens all messages published to message-bus.
        notificationReg = notificationService.registerNotificationListener(this, TOPIC_NOTIFICATION_PATH);
        //LOG.info("Target kafka version is set: " + configuration.getKafkaVersion());
        LOG.info("Creating kafka producer instance using the following configuration");
        LOG.info("metadata.broker.list -> " + configuration.getKafkaBrokerList());
        LOG.info("topic -> " + configuration.getKafkaTopic());
        
        try{
            String topicSubscriptions = configuration.getEventSubscriptions();
            if (topicSubscriptions !=null && !topicSubscriptions.isEmpty())
            {
                LOG.info("adding topic subscriptions : " + topicSubscriptions);
                registeredTopics.addAll(Arrays.asList(topicSubscriptions.split(", ")));
            }
            topic = configuration.getKafkaTopic();
            if (topic ==null)
            {
                throw new Exception ("topic is a mandatory configuration. Kafka producer is not initialised.");
            }
            timestampXPath = configuration.getTimestampXpath();
            hostIpXPath = configuration.getMessageHostIpXpath();
            messageSourceXPath = configuration.getMessageSourceXpath();
            defaultMessageSource = configuration.getDefaultMessageSource();
            
            if (configuration.getDefaultHostIp()!=null)
            {
                DEFAULT_HOST_IP = configuration.getDefaultHostIp();
            }else
            {
                DEFAULT_HOST_IP = "0.0.0.0";
            }
            LOG.info("default host ip is set: " + DEFAULT_HOST_IP);
            producer = new KafkaProducer<String, byte[]>(createProducerConfig(configuration));
            
        }catch(Exception ex)
        {
            LOG.error(ex.getMessage());
            throw new RuntimeException(ex);
            
        }
    }

    private byte[] encode(Long timestamp, String hostIp, String src, String payload) throws IOException
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(out, null);
        GenericRecord datum = new GenericData.Record(schema);
        datum.put("src", src);
        datum.put("timestamp", timestamp);
        datum.put("host_ip", hostIp);
        datum.put("rawdata", ByteBuffer.wrap(payload.getBytes("UTF-8")));
        GenericDatumWriter writer = new GenericDatumWriter<GenericRecord>(schema);
        writer.write(datum, encoder);
        encoder.flush();
        out.close();
        return out.toByteArray();
    }
    
    private static Properties createProducerConfig(KafkaProducerConfig configuration) throws Exception {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("in createProducerConfig()");
        }
        
        Properties props = new Properties();

        //check existence of mandatory configurations
        String brokerList = configuration.getKafkaBrokerList();
        KafkaProducerType producerType = configuration.getKafkaProducerType();
        CompressionType compCodec = configuration.getCompressionType();
        MessageSerialization ser = configuration.getMessageSerialization();
        
        String avroSchemaNameSpace = configuration.getAvroSchemaNamespace();
        if (avroSchemaNameSpace == null)
        {
            throw new Exception("avro schema namespace is a mandatory configuration. Kafka producer is not initialised.");
        }
        
        if (brokerList == null)
        {
            throw new Exception("metadata-broker-list is a mandatory configuration. Kafka producer is not initialised.");
        }


        if (producerType == null)
        {
            throw new Exception("producer-type is a mandatory configuration. Kafka producer is not initialised.");
        }

        if(compCodec == null)
        {
            throw new Exception("compression-codec is a mandatory configuration. Kafka producer is not initialised.");
        }

        if (ser == null)
        {
            throw new Exception ("message-serialization is a mandatory configuration. Kafka producer is not initialised.");
        }
            
        //set mandatory properties
        /*
        if (kafkaVersion.getIntValue() < 1)
        {
            //set producer properties for kafka version 0.8 or lower
            props.put(""+Constants.PROP_MD_BROKER_LIST,  brokerList);
            LOG.info("setting producer type property ...");
            switch (producerType.getIntValue()){
                case 0: props.put(""+Constants.PROP_PRODUCER_TYPE, "sync");
                    LOG.info("producer.type is set as sync");
                    break;
                case 1: props.put(""+Constants.PROP_PRODUCER_TYPE, "async");
                    LOG.info("producer.type is set as async");
                    break;
                default: throw new Exception("Unrecognised producer type " + producerType.getIntValue()+". Kafka producer is not intialised.");
            }
            LOG.info("setting compression codec property ...");
            switch(compCodec.getIntValue())
            {
                case 0: props.put(""+Constants.PROP_PRODUCER_COMPRESSION_CODEC, "none");
                        break;
                case 1: props.put(""+Constants.PROP_PRODUCER_COMPRESSION_CODEC, "gzip");
                        break;
                case 2: props.put(""+Constants.PROP_PRODUCER_COMPRESSION_CODEC, "snappy");
                        break;
                //case 3: props.put(""+Constants.PROP_PRODUCER_COMPRESSION_CODEC, "lz4");
                //        break;
                default: throw new Exception("Unrecognised/unsupported compression encoding " + compCodec.getIntValue()+". Kafka producer is not intialised.");
            }
            LOG.info("setting serialization property ...");
            props.put(""+Constants.PROP_PRODUCER_MSG_ENCODER,Constants.KAFKA_DEFAULT_MSG_ENCODER);
        }else{*/
            
        //set producer properties for kafka version 0.9 or above
        props.put(""+ ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        LOG.info("setting compression codec property ...");
        switch(compCodec.getIntValue())
        {
            case 0: props.put(""+ProducerConfig.COMPRESSION_TYPE_CONFIG, "none");
                    break;
            case 1: props.put(""+ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");
                    break;
            case 2: props.put(""+ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
                    break;
            //case 3: props.put(""+ProducerConfig.COMPRESSION_TYPE_CONFIG, "lz4");
            //        break;
            default: throw new Exception("Unrecognised/unsupported compression type " + compCodec.getIntValue()+". Kafka producer is not intialised.");
        }

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Constants.STR_SERIALIZER_CLASS);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Constants.BYTEARRY_SERIALIZER_CLASS);
        //}
        
        switch(ser.getIntValue())
        {
            case 0: 
                    LOG.info("No serialization set.");
                    schema = null;
                    break;
            case 1: 
                    LOG.info("load schema from classpath  ...");
                    
                    schema = new Schema.Parser().parse(loadAvroSchemaAsString(avroSchemaNameSpace));
                    LOG.info("schema loaded.");
                    break;
             default: 
                    throw new Exception("Unrecognised message serialization type " + ser.getIntValue()+". Kafka producer is not intialised.");
        }

        LOG.info("creating ProducerConfig instance...");
        return props;
    }
    
    /**
     * Extract raw event payload
     * @param notification
     * @return 
     */
    private String parsePayLoad(DOMNotification notification){

        if (LOG.isDebugEnabled())
        {
            LOG.debug("in parsePayLoad");
        }
        final AnyXmlNode encapData = (AnyXmlNode) notification.getBody().getChild(PAYLOAD_NODE).get();
        
        final StringWriter writer = new StringWriter();
        final StreamResult result = new StreamResult(writer);
        final TransformerFactory tf = TransformerFactory.newInstance();
        try {
        final Transformer transformer = tf.newTransformer();
            transformer.transform(encapData.getValue(), result);
        } catch (TransformerException e) {
            LOG.error("Can not parse PayLoad data", e);
            return null;
        }
        writer.flush();
        return writer.toString();
    }
    
    /**
     * Utility function that loads XML document from string
     * @param xml
     * @return XML Document
     * @throws Exception 
     */
    private static Document loadXmlFromString (String xml) throws Exception
    {
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        fac.setNamespaceAware(false);
        DocumentBuilder builder = fac.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));
        return doc;
    }
    
    /**
     * Evaluate XPath 
     * @param payload
     * @param xpathStmt
     * @return
     * @throws Exception 
     */
    private String evaluate (String payload, String xpathStmt) throws Exception
    {
        String result = null;
        
        Document doc = loadXmlFromString(payload);

        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xpath.evaluate(xpathStmt, doc, XPathConstants.NODESET);
        System.out.println(nodeList.getLength());
        if (nodeList.getLength()>0)
        {
            Node node = nodeList.item(0);
            result = node.getTextContent();
        }
        
        return result;
    }
    
    /**
     * Load avro schema and replace namespace with user-defined value
     * @param namespace
     * @return avro schema
     * @throws Exception 
     */
    private static String loadAvroSchemaAsString (String namespace) throws Exception
    {
        String avroSchemaStr;
        StringBuilder sb = new StringBuilder("");
        InputStream is = KafkaUserAgentImpl.class.getClassLoader().getResourceAsStream(avroSchema);
        try (Scanner scanner = new Scanner(is)) {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                sb.append(line);
            }
        }
        avroSchemaStr = String.format(sb.toString(), namespace);
        return avroSchemaStr;
    }
    
    
}
