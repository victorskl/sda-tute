# Workshop 9 

Enterprise Messaging with Java Messaging Service (JMS)

## ActiveMQ

- Start the ActiveMQ

```
PS D:\Tools\apache-activemq-5.15.2\bin> .\activemq.bat start
```

- ActiveMQ's admin console  http://localhost:8161/admin/queues.jsp

	Username: admin
	Password: admin
	
- These are defined at `D:\Tools\apache-activemq-5.15.2\conf\jetty-realm.properties`

## Activity 1:
 
- Developing a simple Sender/Receiver for Point-to-Point Communication

- Hit and Run as Java Application on `simple.Producer.java` and `simple.Consumer.java`

- Observe through ActiveMQ Admin Console > Queue


## Activity 2: 

- Developing a more complex Sender/Receiver for Point-to-Point Communication

- Hit and Run as Java Application on `complex.Consumer.java` x4 i.e. creating 4 consumer instances

- Hit and Run as Java Application on `complex.Producer.java`


```
Consumer 1 Console:
Received: Message: 0 sent at: Mon Oct 30 12:53:27 AEDT 2017 ...' (length 255)
Received: Message: 4 sent at: Mon Oct 30 12:53:31 AEDT 2017 ...' (length 255)
Received: Message: 8 sent at: Mon Oct 30 12:53:35 AEDT 2017 ...' (length 255)

Consumer 2 Console:
Received: Message: 1 sent at: Mon Oct 30 12:53:28 AEDT 2017 ...' (length 255)
Received: Message: 5 sent at: Mon Oct 30 12:53:32 AEDT 2017 ...' (length 255)
Received: Message: 9 sent at: Mon Oct 30 12:53:36 AEDT 2017 ...' (length 255)

Consumer 3 Console:
Received: Message: 2 sent at: Mon Oct 30 12:53:29 AEDT 2017 ...' (length 255)
Received: Message: 6 sent at: Mon Oct 30 12:53:33 AEDT 2017 ...' (length 255)

Consumer 4 Console:
Received: Message: 3 sent at: Mon Oct 30 12:53:30 AEDT 2017 ...' (length 255)
Received: Message: 7 sent at: Mon Oct 30 12:53:34 AEDT 2017 ...' (length 255)
```

### Threading

- `complex.ProducerTool.java` and `complex.ConsumerTool.java` are the threaded counterpart of the same thing.

- Make sure to terminate all the `complex.Consumer.java` from the previous section.

- Hit and Run as Java Application on `complex.ConsumerTool.java`

- Hit and Run as Java Application on `complex.ProducerTool.java`

```
[Thread-2] Received: 'Message: 0 sent at: Mon Oct 30 13:04:42 AEDT 2017 ...' (length 255)
[Thread-1] Received: 'Message: 1 sent at: Mon Oct 30 13:04:42 AEDT 2017 ...' (length 255)
[Thread-1] Received: 'Message: 3 sent at: Mon Oct 30 13:04:42 AEDT 2017 ...' (length 255)
[Thread-2] Received: 'Message: 2 sent at: Mon Oct 30 13:04:42 AEDT 2017 ...' (length 255)
[Thread-1] Received: 'Message: 5 sent at: Mon Oct 30 13:04:42 AEDT 2017 ...' (length 255)
[Thread-2] Received: 'Message: 4 sent at: Mon Oct 30 13:04:42 AEDT 2017 ...' (length 255)
[Thread-2] Received: 'Message: 6 sent at: Mon Oct 30 13:04:42 AEDT 2017 ...' (length 255)
[Thread-1] Received: 'Message: 7 sent at: Mon Oct 30 13:04:42 AEDT 2017 ...' (length 255)
[Thread-2] Received: 'Message: 8 sent at: Mon Oct 30 13:04:42 AEDT 2017 ...' (length 255)
[Thread-1] Received: 'Message: 9 sent at: Mon Oct 30 13:04:42 AEDT 2017 ...' (length 255)
```

