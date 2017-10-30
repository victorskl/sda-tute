package complex;

/**
 * This is a simplified version of the original program - modified by Shanika Karunasekera
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.util.IndentPrinter;

/**
 * A simple producer program for publishing messages
 * 
 */
public class Producer {

    private Destination destination;
    private int messageCount = 10;
    private long sleepTime = 1000;
    private boolean verbose = true;
    private int messageSize = 255;
    private long timeToLive;
    private String user = ActiveMQConnection.DEFAULT_USER;
    private String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private String subject = "TOOL.DEFAULT";
    private boolean transacted;
    private boolean persistent;
    private static Object lockResults = new Object();

    public static void main(String[] args) {

	Producer producer = new Producer();
	producer.showParameters();
	producer.run();
    }

    public void showParameters() {
	System.out.println("Connecting to URL: " + url + " (" + user + ":" + password + ")");
	System.out.println("Using " + (persistent ? "persistent" : "non-persistent") + " messages");
	System.out.println("Sleeping between publish " + sleepTime + " ms");

	if (timeToLive != 0) {
	    System.out.println("Messages time to live " + timeToLive + " ms");
	}
    }

    public void run() {
	Connection connection = null;
	try {
	    // Create the connection.
	    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
	    connection = connectionFactory.createConnection();
	    connection.start();

	    // Create the session
	    Session session = connection.createSession(transacted, Session.AUTO_ACKNOWLEDGE);

	    destination = session.createQueue(subject);

	    // Create the producer.
	    MessageProducer producer = session.createProducer(destination);
	    if (persistent) {
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
	    } else {
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	    }
	    if (timeToLive != 0) {
		producer.setTimeToLive(timeToLive);
	    }

	    // Start sending messages
	    sendLoop(session, producer);

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		connection.close();
	    } catch (Throwable ignore) {
	    }
	}
    }

    protected void sendLoop(Session session, MessageProducer producer) throws Exception {

	for (int i = 0; i < messageCount || messageCount == 0; i++) {

	    TextMessage message = session.createTextMessage(createMessageText(i));

	    System.out.println("Sending message: " + message);

	    producer.send(message);

	    if (transacted) {
		session.commit();
	    }
	    System.out.println("Sleeping for " + sleepTime + " milliseconds");
	    Thread.sleep(sleepTime);
	}
    }

    private String createMessageText(int index) {
	StringBuffer buffer = new StringBuffer(messageSize);
	buffer.append("Message: " + index + " sent at: " + new Date());
	if (buffer.length() > messageSize) {
	    return buffer.substring(0, messageSize);
	}
	for (int i = buffer.length(); i < messageSize; i++) {
	    buffer.append(' ');
	}
	return buffer.toString();
    }

    public void setPersistent(boolean durable) {
	this.persistent = durable;
    }

    public void setMessageCount(int messageCount) {
	this.messageCount = messageCount;
    }

    public void setMessageSize(int messageSize) {
	this.messageSize = messageSize;
    }

    public void setPassword(String pwd) {
	this.password = pwd;
    }

    public void setSleepTime(long sleepTime) {
	this.sleepTime = sleepTime;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public void setTimeToLive(long timeToLive) {
	this.timeToLive = timeToLive;
    }

    public void setTransacted(boolean transacted) {
	this.transacted = transacted;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public void setUser(String user) {
	this.user = user;
    }

    public void setVerbose(boolean verbose) {
	this.verbose = verbose;
    }
}
