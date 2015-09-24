# odl-kafka-plugin
##Overview
`odl-kafka-plugin` is an Opendaylight (ODL)  northbound plugin that allows real-time or near real-time event or telemetry data streaming into such a big-data platform as PaNDA. The key design goal of this plugin is to provide a genenric and configurable data connector that subscribes to southbound event source(s) via ODL's Event Topic Broker (ETB) on one side, and forward notifications to a Kafka endpoint.

The `odl-kafka-plugin` has been development using Lithium maven artetype and tested using ODL Lithium 0.3.0 container (distribution-karaf-0.3.0-Lithium). 

##Quick Start
######Step 1: Clone `kafka-agent` source code
```
$git clone 
```

######Step 2: Build from source
```
$cd kafka-agent
$mvn clean install -Dcheckstyle.skip=true -DskipTests=true
```
######Step 3: Start ODL container
```
$./karaf/target/assembly/bin/karaf
```
You can verify the installation of all modules by running the command from ODL console as follows:
```
opendaylight-user@root>feature:list | grep 'hwevent'
odl-hweventsource-api             | 1.0-Lithium      | x         | odl-hweventsource-1.0-Lithium        | OpenDaylight :: hweventsource :: api              
odl-hweventsource                 | 1.0-Lithium      | x         | odl-hweventsource-1.0-Lithium        | OpenDaylight :: hweventsource                     
odl-hweventsource-rest            | 1.0-Lithium      | x         | odl-hweventsource-1.0-Lithium        | OpenDaylight :: hweventsource :: REST             
odl-hweventsource-ui              | 1.0-Lithium      | x         | odl-hweventsource-1.0-Lithium        | OpenDaylight :: hweventsource :: UI               
odl-hweventsource-uagent          | 1.0-Lithium      | x         | odl-hweventsource-1.0-Lithium        | OpenDaylight :: hweventsource :: UserAgent
```
######Step 4: Start Zookeeper and Kafka Server
```
$cd $KAFKA_HOME
$bin/zookeeper-server-start.sh config/zookeeper.properties
$bin/kafka-server-start.sh config/server.properties
```
Create a 'odlmsg' topic
```
$bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic odlmsg
```
Start a consumer and listens to the topic
```
$bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic odlmsg --from-beginning
```

######Step 5: Follow the ODL EBK online tutorial to explort the functionality 
Now follow the instructions (section Exploring the Functionality avaiable at: https://wiki.opendaylight.org/view/Controller_Core_Functionality_Tutorials:Tutorials:Event_/_Notification_Manager#Building_the_Project), and keep an eye on the kafka consumer console. You should be able to see the "hello world" message arrives every three seconds. 



   


