/*
 * [To Do: Use OpenDayLight licence]
 */
package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.impl.rev150922;

import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ConsumerContext;
import org.opendaylight.controller.sal.binding.api.BindingAwareConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Xiaoyu Chen
 */
public class NoopBindingConsumer implements BindingAwareConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(NoopBindingConsumer.class);

    @Override
    public void onSessionInitialized(ConsumerContext session) {
        LOG.info("NoopBindingConsumer initialized");
    }

}
