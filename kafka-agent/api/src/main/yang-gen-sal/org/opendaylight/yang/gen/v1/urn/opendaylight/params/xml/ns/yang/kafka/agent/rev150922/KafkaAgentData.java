package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.rev150922;
import org.opendaylight.yangtools.yang.binding.DataRoot;


/**
 * PaNDA Kafka user agent
 *
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;kafka-agent&lt;/b&gt;
 * &lt;br&gt;Source path: &lt;i&gt;META-INF/yang/kafka-agent.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * module kafka-agent {
 *     yang-version 1;
 *     namespace "urn:opendaylight:params:xml:ns:yang:kafka-agent";
 *     prefix "kafka-agent";
 *
 *     revision 2015-09-22 {
 *         description "PaNDA Kafka user agent
 *         ";
 *     }
 *
 *     container kafka-producer-config {
 *         leaf metadata-broker-list {
 *             type string;
 *         }
 *         leaf producer-type {
 *             type enumeration;
 *         }
 *         leaf compression-codec {
 *             type enumeration;
 *         }
 *         leaf topic {
 *             type string;
 *         }
 *         leaf message-serialization {
 *             type enumeration;
 *         }
 *         leaf dp-message-source-xpath {
 *             type string;
 *         }
 *         leaf dp-message-host-ip-xpath {
 *             type string;
 *         }
 *         leaf dp-timestamp-xpath {
 *             type string;
 *         }
 *         leaf avro-schema {
 *             type string;
 *         }
 *         leaf default-host-ip {
 *             type string;
 *         }
 *     }
 * }
 * &lt;/pre&gt;
 *
 */
public interface KafkaAgentData
    extends
    DataRoot
{




    KafkaProducerConfig getKafkaProducerConfig();

}

