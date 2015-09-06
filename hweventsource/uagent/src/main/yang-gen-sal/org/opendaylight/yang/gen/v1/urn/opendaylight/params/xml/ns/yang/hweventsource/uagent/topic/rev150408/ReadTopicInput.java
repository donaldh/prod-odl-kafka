package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;uagent-topic-read&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF/yang/uagent-topic-read.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * container input {
 *     leaf topic-id {
 *         type topic-id;
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;uagent-topic-read/read-topic/input&lt;/i&gt;
 *
 * &lt;p&gt;To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInputBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInputBuilder
 *
 */
public interface ReadTopicInput
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408.ReadTopicInput>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:hweventsource:uagent:topic","2015-04-08","input"));

    TopicId getTopicId();

}

