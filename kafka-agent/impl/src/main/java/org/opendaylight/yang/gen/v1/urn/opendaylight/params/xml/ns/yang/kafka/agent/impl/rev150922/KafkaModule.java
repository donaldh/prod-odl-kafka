/************************************************************************************************************
* Copyright (c) 2016 Cisco and/or its affiliates.
* This software is licensed to you under the terms of the Apache License, Version 2.0 (the "License").
* You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
* The code, technical concepts, and all information contained herein, are the property of Cisco Technology, Inc.
* and/or its affiliated entities, under various laws including copyright, international treaties, patent,
* and/or contract. Any use of the material herein must be in accordance with the terms of the License.
* All rights not expressly granted by the License are reserved.
* Unless required by applicable law or agreed to separately in writing, software distributed under the
* License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
* either express or implied.
* 

* Name:       KafkaModule.java
* Purpose:    Kafka module implementation class
*************************************************************************************************************/


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
