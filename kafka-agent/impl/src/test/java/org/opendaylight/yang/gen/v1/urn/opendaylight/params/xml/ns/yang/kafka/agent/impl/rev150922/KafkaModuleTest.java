/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    
    @Test
    public void testCreateInstance() throws Exception {
        // configure mocks
        DependencyResolver dependencyResolver = mock(DependencyResolver.class);
        BindingAwareBroker broker = mock(BindingAwareBroker.class);
        
        when(dependencyResolver.resolveInstance(eq(BindingAwareBroker.class), any(ObjectName.class), any(JmxAttribute.class))).thenReturn(broker);
        
        // create instance of module with injected mocks
        KafkaModule module = new KafkaModule(mock(ModuleIdentifier.class), dependencyResolver);
        try{
            // getInstance calls resolveInstance to get the broker dependency and then calls createInstance
            AutoCloseable closeable = module.getInstance();
           
            // ensure no exceptions on close
            closeable.close();
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}