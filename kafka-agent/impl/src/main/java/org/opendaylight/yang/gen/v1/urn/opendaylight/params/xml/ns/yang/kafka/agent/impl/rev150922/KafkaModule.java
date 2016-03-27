/*
 * [To Do: Use OpenDayLight licence]
 */

package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.impl.rev150922;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.dom.api.DOMNotificationService;
import org.opendaylight.kafkacluster.impl.KafkaUserAgentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaModule extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.impl.rev150922.AbstractKafkaModule {
    
    //Private variable --
    private static final Logger LOG = LoggerFactory.getLogger(KafkaModule.class);
    
    
    //Public methods --
    
    /**
     * Constructor
     * @param identifier
     * @param dependencyResolver 
     */
    public KafkaModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        
        super(identifier, dependencyResolver);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("in KafkaModule()");
        }
    }

    /**
     * Constructor
     * @param identifier
     * @param dependencyResolver
     * @param oldModule
     * @param oldInstance 
     */
    public KafkaModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.impl.rev150922.KafkaModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("in KafkaModule()");
        }
    }

    /**
     * Validate module attributes
     */
    @Override
    public void customValidation() {
        // do nothing.
        if (LOG.isDebugEnabled())
        {
            LOG.debug("in customValidation()");
        }
    }

    /**
     * Factory method to create a KafkaUserAgentFactory instance
     * @return 
     */
    @Override
    public java.lang.AutoCloseable createInstance() {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("in createInstance()");
        }
        final DataBroker dataBroker = getBindingBrokerDependency()
                .registerConsumer(new NoopBindingConsumer())
                .getSALService(DataBroker.class);
         final DOMNotificationService notifyService = getDomBrokerDependency()
                .registerConsumer(new NoopDOMConsumer())
                .getService(DOMNotificationService.class);
        return new KafkaUserAgentFactory(dataBroker, notifyService);
    }

}
