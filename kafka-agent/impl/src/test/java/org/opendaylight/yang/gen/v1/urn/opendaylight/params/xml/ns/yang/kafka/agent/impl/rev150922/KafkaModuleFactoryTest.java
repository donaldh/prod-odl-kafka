/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.kafka.agent.impl.rev150922;

import org.junit.Test;

/**
 *
 * @author williscc
 */
public class KafkaModuleFactoryTest {
    @Test
    public void testFactoryConstructor(){
        //ensure no exceptions on construction
        new KafkaModuleFactory();
    }
}
