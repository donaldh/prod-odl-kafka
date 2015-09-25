package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hweventsource.uagent.topic.rev150408;
import java.util.concurrent.Future;
import org.opendaylight.yangtools.yang.binding.RpcService;
import org.opendaylight.yangtools.yang.common.RpcResult;


/**
 * Interface for implementing the following YANG RPCs defined in module &lt;b&gt;uagent-topic-read&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF/yang/uagent-topic-read.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * rpc read-topic {
 *     "Request to read nofication from topic identified by topicId.";
 *     input {
 *         leaf topic-id {
 *             type topic-id;
 *         }
 *     }
 *     
 *     status CURRENT;
 * }
 * &lt;/pre&gt;
 *
 */
public interface UagentTopicReadService
    extends
    RpcService
{




    /**
     * Request to read nofication from topic identified by topicId.
     *
     */
    Future<RpcResult<java.lang.Void>> readTopic(ReadTopicInput input);

}

