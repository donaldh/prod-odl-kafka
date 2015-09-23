/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opendaylight.panda.impl;

import static com.google.common.util.concurrent.Futures.immediateFuture;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.logging.Level;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import kafka.producer.KeyedMessage;
import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.controller.md.sal.dom.api.DOMNotification;
import org.opendaylight.controller.md.sal.dom.api.DOMNotificationListener;
import org.opendaylight.controller.md.sal.dom.api.DOMNotificationService;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.cisco.params.xml.ns.yang.messagebus.eventaggregator.rev141202.TopicId;
import org.opendaylight.yang.gen.v1.urn.cisco.params.xml.ns.yang.messagebus.eventaggregator.rev141202.TopicNotification;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922.KafkaProducerConfig;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.opendaylight.yangtools.yang.data.api.YangInstanceIdentifier.NodeIdentifier;
import org.opendaylight.yangtools.yang.data.api.schema.AnyXmlNode;
import org.opendaylight.yangtools.yang.model.api.SchemaPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author williscc
 */
public class KafkaUserAgentImpl implements DOMNotificationListener, AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaUserAgentImpl.class);
    
    private final ListenerRegistration<KafkaUserAgentImpl> notificationReg;
    
    private final NodeIdentifier EVENT_SOURCE_NODE = new NodeIdentifier(QName.create(TopicNotification.QNAME, "node-id"));
    private final NodeIdentifier PAYLOAD_NODE = new NodeIdentifier(QName.create(TopicNotification.QNAME, "payload"));
    
    private final SchemaPath TOPIC_NOTIFICATION_PATH = SchemaPath.create(true, TopicNotification.QNAME);
    
    private final String defaultAvroSchema = "dataplatform-raw.avrc";
    
    private KafkaUserAgentImpl (final DOMNotificationService notificationService, final KafkaProducerConfig configuration)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("in KafkaUserAgentImpl()");
        }
        
        LOG.info("registering to Notification Service broker");
        //register this as a listener to notification service and listens all messages published to message-bus.
        notificationReg = notificationService.registerNotificationListener(this, TOPIC_NOTIFICATION_PATH);
        
        LOG.info("Creating kafka producer instance using the following configuration");
        LOG.info("metadata.broker.list -> " + configuration.getMetadataBrokerList());
        LOG.info("topic -> " + configuration.getTopic());
        
    }
    
    public static KafkaUserAgentImpl create(final DOMNotificationService notificationService, final KafkaProducerConfig configuration)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("in create()");
        }
        return new KafkaUserAgentImpl (notificationService, configuration);
    }
    
    @Override
    public void onNotification(DOMNotification notification) {
        
        if (LOG.isDebugEnabled())
        {
            LOG.debug("in onNotification()");
        }
        
        LOG.info("Notification received.");
        
        final String nodeId = notification.getBody().getChild(EVENT_SOURCE_NODE).get().getValue().toString();
        LOG.info("node-id: " + nodeId);
        final String payLoad = notification.getBody().getChild(PAYLOAD_NODE).get().getValue().toString();
        LOG.info("paylaod: " + payLoad);
        LOG.info("just about to send message to PaNDA (to be implemented) ...");
        
    }

    @Override
    public void close() throws Exception {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("in close()");
        }
    }
   
    
    
    

}
