# odl-kafka-plugin
##Overview
`odl-kafka-plugin` is an Opendaylight (ODL)  northbound plugin that allows real-time or near real-time event or telemetry data streaming into such a big-data platform as PaNDA. The key design goal of this plugin is to provide a genenric and configurable data connector that subscribes to southbound event source(s) via ODL's Event Topic Broker (ETB) on one side, and forward notifications to a Kafka endpoint.

##Current status
The development so far provides a PoC implementation based on a sample eventsource from the coretutorial ODL Lithium 0.3.0 (distribution-karaf-0.3.0-Lithium). The kafka configurations are hardcoded by using the following default values:
```
metadata.broker.list=localhost:9082
producer.type=sync
compression.codec=none
serializer.class=kafka.serializer.DefaultEncoder
topic=odlmsg
```
[NOTE: These parameters will be configuration via NETCONF protocol in the next release]
##Prerequiste
In order to run the PoC implementation, you will need to install Kafka (0.8.*) in single node mode on your machine. Details on Kafka installation can be found at http://kafka.apache.org/documentation.html#quickstart. 

For those intended to deploy the PoC plugin to a pre-existed ODL container, you will need to make sure you are using the ODL Lithium 0.3.0. 
     
##Quick Start
######Step 1: Clone the code using the URL of this page. 
######Step 2: Build from source
```
$cd odl-kafka-plugin/hweventsource
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
bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic odlmsg --from-beginning
```

######Step 5: Follow the ODL EBK online tutorial to explort the functionality 
Now follow the instructions (section Exploring the Functionality avaiable at: https://wiki.opendaylight.org/view/Controller_Core_Functionality_Tutorials:Tutorials:Event_/_Notification_Manager#Building_the_Project), and keep an eye on the kafka consumer console. You should be able to see the "hello world" message arrives every three seconds. 



   


