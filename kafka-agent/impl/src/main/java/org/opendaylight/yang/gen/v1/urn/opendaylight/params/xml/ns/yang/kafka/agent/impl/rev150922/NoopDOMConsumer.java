/*
 * [To Do: Use OpenDayLight licence]
 */
package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.impl.rev150922;

import java.util.Collection;
import java.util.Collections;

import org.opendaylight.controller.sal.core.api.Broker.ConsumerSession;
import org.opendaylight.controller.sal.core.api.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Xiaoyu Chen
 */
public class NoopDOMConsumer implements Consumer {

    private static final Logger LOG = LoggerFactory.getLogger(NoopDOMConsumer.class);

    @Override
    public void onSessionInitiated(final ConsumerSession session) {
        LOG.info("NoopDOMConsumer initialized");
    }

    @Override
    public Collection<ConsumerFunctionality> getConsumerFunctionality() {
        return Collections.emptySet();
    }

}
