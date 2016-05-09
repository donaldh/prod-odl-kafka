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

* Name:       Kafka-agent
* Purpose:    Kafka agent POM file
* Author:     PaNDA team
* Created:    07-Sept-2015
* Updated:    09-May-2015
*************************************************************************************************************/
package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.impl.rev150922;

import javax.management.ObjectName;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.opendaylight.controller.config.api.DependencyResolver;
import org.opendaylight.controller.config.api.JmxAttribute;
import org.opendaylight.controller.config.api.ModuleIdentifier;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker;

public class KafkaModuleTest {
    @Test
    public void testCustomValidation() {
        KafkaModule module = new KafkaModule(mock(ModuleIdentifier.class), mock(DependencyResolver.class));

        // ensure no exceptions on validation
        // currently this method is empty
        module.customValidation();
    }

    
//    @Test
//    public void testCreateInstance() throws Exception {
//        // configure mocks
//        DependencyResolver dependencyResolver = mock(DependencyResolver.class);
//        BindingAwareBroker broker = mock(BindingAwareBroker.class);
//        
//        when(dependencyResolver.resolveInstance(eq(BindingAwareBroker.class), any(ObjectName.class), any(JmxAttribute.class))).thenReturn(broker);
//        
//        // create instance of module with injected mocks
//        KafkaModule module = new KafkaModule(mock(ModuleIdentifier.class), dependencyResolver);
//        try{
//            // getInstance calls resolveInstance to get the broker dependency and then calls createInstance
//            AutoCloseable closeable = module.getInstance();
//           
//            // ensure no exceptions on close
//            closeable.close();
//        }catch(Exception ex)
//        {
//            System.out.println(ex.getMessage());
//        }
//    }
}