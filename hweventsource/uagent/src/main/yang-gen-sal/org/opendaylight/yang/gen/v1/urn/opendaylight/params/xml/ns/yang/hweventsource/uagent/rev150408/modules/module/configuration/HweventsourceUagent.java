package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.hweventsource.uagent.Broker;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.hweventsource.uagent.DomBroker;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;hweventsource-uagent&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF/yang/hweventsource-uagent.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * case hweventsource-uagent {
 *     container broker {
 *         leaf type {
 *             type leafref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:hweventsource:uagent?revision=2015-04-08)type {
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
 *             refine (urn:opendaylight:params:xml:ns:yang:hweventsource:uagent?revision=2015-04-08)type {
 *                 leaf type {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *     }
 *     leaf output-file-name {
 *         type string;
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;hweventsource-uagent/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:hweventsource:uagent?revision=2015-04-08)hweventsource-uagent&lt;/i&gt;
 *
 */
public interface HweventsourceUagent
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.rev150408.modules.module.configuration.HweventsourceUagent>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:hweventsource:uagent","2015-04-08","hweventsource-uagent"));

    Broker getBroker();
    
    DomBroker getDomBroker();
    
    /**
     * Name of file where hweventsource-uagent will write notification
     *
     */
    java.lang.String getOutputFileName();

}

