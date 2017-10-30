# Workshop 9 

Enterprise Messaging with Java Messaging Service (JMS)

- Make reuse of `JMSPointToPoint\lib` as reference libraries

## ActiveMQ

- Start the ActiveMQ

```
PS D:\Tools\apache-activemq-5.15.2\bin> .\activemq.bat start
```

- ActiveMQ's admin console  http://localhost:8161/admin/queues.jsp

	Username: admin
	Password: admin
	
- These are defined at `D:\Tools\apache-activemq-5.15.2\conf\jetty-realm.properties`


## Activity 3: Developing a Publisher/Subscriber for Publish Subscribe Communication

- The key aspect between **PointToPoint** Vs **Publisher/Subscriber** is **Queue** Vs **Topic**: 

```
session.createQueue(subject); 
...
session.createTextMessage("Hello");
```

- instead of 

```
session.createTopic("topictest.messages");
...
session.createBytesMessage();
```

- Hit and Run as Java Application `simplified.Subscriber.java` and `simplified.Publisher.java`

- Note if you run `complex.TopicListener.java` and `complex.TopicPublisher.java`, you need to wait until `2000 x 10000` messages have reached which will take awhile. Check the [screenshot](activemq_admin_console_topic.png).

```
...
...
Waiting for completion...
Received report Received 10000 in 398ms 0 remaining
Batch 1998 of 2000 completed in 398 ms.
Sent 1000 messages
Sent 2000 messages
Sent 3000 messages
Sent 4000 messages
Sent 5000 messages
Sent 6000 messages
Sent 7000 messages
Sent 8000 messages
Sent 9000 messages
Sent 10000 messages
Waiting for completion...
Received report Received 10000 in 414ms 0 remaining
Batch 1999 of 2000 completed in 414 ms.
Sent 1000 messages
Sent 2000 messages
Sent 3000 messages
Sent 4000 messages
Sent 5000 messages
Sent 6000 messages
Sent 7000 messages
Sent 8000 messages
Sent 9000 messages
Sent 10000 messages
Waiting for completion...
Received report Received 10000 in 410ms 0 remaining
Batch 2000 of 2000 completed in 411 ms.
min: 351, max: 812 avg: 403
```

### ActiveMQ Admin Console Screenshot after runs

- [activemq_admin_console_queue.png](activemq_admin_console_queue.png)

- [activemq_admin_console_topic.png](activemq_admin_console_topic.png)


### TODO

- https://spring.io/blog/2011/01/26/green-beans-getting-started-with-enterprise-messaging-and-spring