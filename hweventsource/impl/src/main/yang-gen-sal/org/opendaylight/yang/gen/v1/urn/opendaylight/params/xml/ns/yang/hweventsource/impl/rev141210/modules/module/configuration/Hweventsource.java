package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.impl.rev141210.modules.module.configuration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.impl.rev141210.modules.module.configuration.hweventsource.Broker;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.impl.rev141210.modules.module.configuration.hweventsource.EventSourceRegistry;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.impl.rev141210.modules.module.configuration.hweventsource.DomBroker;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;hweventsource-impl&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF/yang/hweventsource-impl.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * case hweventsource {
 *     container broker {
 *         leaf type {
 *             type leafref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:hweventsource:impl?revision=2014-12-10)type {
 *                 leaf type {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *     }
 *     container dom-broker {
 *         leaf type {
 *             type leafref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:hweventsource:impl?revision=2014-12-10)type {
 *                 leaf type {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *     }
 *     container event-source-registry {
 *         leaf type {
 *             type leafref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:hweventsource:impl?revision=2014-12-10)type {
 *                 leaf type {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *     }
 *     leaf number-event-sources {
 *         type uint8;
 *     }
 *     leaf message-generate-period {
 *         type uint8;
 *     }
 *     leaf message-text {
 *         type string;
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;hweventsource-impl/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:hweventsource:impl?revision=2014-12-10)hweventsource&lt;/i&gt;
 *
 */
public interface Hweventsource
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.impl.rev141210.modules.module.configuration.Hweventsource>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:hweventsource:impl","2014-12-10","hweventsource"));

    Broker getBroker();
    
    DomBroker getDomBroker();
    
    EventSourceRegistry getEventSourceRegistry();
    
    /**
     * Sample application will generate given number of sample event sources.
     *
     */
    java.lang.Short getNumberEventSources();
    
    /**
     * Each event source will generate message in given interval (seconds).
     *
     */
    java.lang.Short getMessageGeneratePeriod();
    
    /**
     * Text of message produced by each event source
     *
     */
    java.lang.String getMessageText();

}

