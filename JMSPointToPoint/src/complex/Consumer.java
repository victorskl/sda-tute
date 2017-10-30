package complex;
/**
 * This is a simplified version of the original program - modified by Shanika Karunasekera
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

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * A simple tool for consuming messages
 * 
 * 
 */
public class Consumer implements MessageListener, ExceptionListener {

    private boolean running;

    private Session session;
    private Destination destination;
    private MessageProducer replyProducer;
    private boolean pauseBeforeShutdown = false;
    private boolean verbose = true;
    private int maxiumMessages;
    private String subject = "TOOL.DEFAULT";
    private String user = ActiveMQConnection.DEFAULT_USER;
    private String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private boolean transacted;
    private boolean durable;
    private String clientId;
    private int ackMode = Session.AUTO_ACKNOWLEDGE;
    private String consumerName = "James";
    private long sleepTime;
    private long receiveTimeOut;
    private long batch = 10; // Default batch size for CLIENT_ACKNOWLEDGEMENT or SESSION_TRANSACTED
    private long messagesReceived = 0;

    public static void main(String[] args) {
	Consumer consumer = new Consumer();
	consumer.showParameters();
	consumer.run();
    }

    public void showParameters() {
	System.out.println("Connecting to URL: " + url + " (" + user + ":" + password + ")");
	System.out.println("Using a " + (durable ? "durable" : "non-durable") + " subscription");
    }

    public void run() {
	try {
	    running = true;

	    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
	    Connection connection = connectionFactory.createConnection();
	    if (durable && clientId != null && clientId.length() > 0 && !"null".equals(clientId)) {
		connection.setClientID(clientId);
	    }
	    connection.setExceptionListener(this);
	    connection.start();

	    session = connection.createSession(transacted, ackMode);

	    destination = session.createQueue(subject);
	    replyProducer = session.createProducer(null);
	    replyProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

	    MessageConsumer consumer = null;
	    consumer = session.createConsumer(destination);

	    if (maxiumMessages > 0) {
		consumeMessagesAndClose(connection, session, consumer);
	    } else {
		if (receiveTimeOut == 0) {
		    consumer.setMessageListener(this);
		} else {
		    consumeMessagesAndClose(connection, session, consumer, receiveTimeOut);
		}
	    }

	} catch (Exception e) {
	    System.out.println(" Caught: " + e);
	    e.printStackTrace();
	}
    }

    @Override
    public void onMessage(Message message) {

	messagesReceived++;

	try {

	    if (message instanceof TextMessage) {
		TextMessage txtMsg = (TextMessage) message;
		if (verbose) {

		    String msg = txtMsg.getText();
		    int length = msg.length();
		    if (length > 50) {
			msg = msg.substring(0, 50) + "...";
		    }
		    System.out.println("Received: " + msg + "' (length " + length + ")");
		}
	    }

	    if (message.getJMSReplyTo() != null) {
		replyProducer.send(message.getJMSReplyTo(),
			session.createTextMessage("Reply: " + message.getJMSMessageID()));
	    }

	    if (transacted) {
		if ((messagesReceived % batch) == 0) {
		    System.out.println("Commiting transaction for last " + batch + " messages; messages so far = "
			    + messagesReceived);
		    session.commit();
		}
	    } 
	    
	    else if (ackMode == Session.CLIENT_ACKNOWLEDGE) {
		if ((messagesReceived % batch) == 0) {
		    System.out.println(
			    "Acknowledging last " + batch + " messages; messages so far = " + messagesReceived);
		    message.acknowledge();
		}
	    }

	} catch (JMSException e) {
	    e.printStackTrace();
	} finally {
	    if (sleepTime > 0) {
		try {
		    Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
		}
	    }
	}
    }

    public synchronized void onException(JMSException ex) {
	running = false;
    }

    synchronized boolean isRunning() {
	return running;
    }

    protected void consumeMessagesAndClose(Connection connection, Session session, MessageConsumer consumer)
	    throws JMSException, IOException {

	for (int i = 0; i < maxiumMessages && isRunning();) {
	    Message message = consumer.receive(1000);
	    if (message != null) {
		i++;
		onMessage(message);
	    }
	}

	consumer.close();
	session.close();
	connection.close();
	if (pauseBeforeShutdown) {
	    System.in.read();
	}
    }

    protected void consumeMessagesAndClose(Connection connection, Session session, MessageConsumer consumer, long timeout) 
	    throws JMSException, IOException {

	Message message;
	while ((message = consumer.receive(timeout)) != null) {
	    onMessage(message);
	}
	consumer.close();
	session.close();
	connection.close();
	if (pauseBeforeShutdown) {
	    System.out.println("Press return to shut down");
	    System.in.read();
	}
    }

    public void setAckMode(String ackMode) {
	if ("CLIENT_ACKNOWLEDGE".equals(ackMode)) {
	    this.ackMode = Session.CLIENT_ACKNOWLEDGE;
	}
	if ("AUTO_ACKNOWLEDGE".equals(ackMode)) {
	    this.ackMode = Session.AUTO_ACKNOWLEDGE;
	}
	if ("DUPS_OK_ACKNOWLEDGE".equals(ackMode)) {
	    this.ackMode = Session.DUPS_OK_ACKNOWLEDGE;
	}
	if ("SESSION_TRANSACTED".equals(ackMode)) {
	    this.ackMode = Session.SESSION_TRANSACTED;
	}
    }

    public void setClientId(String clientID) {
	this.clientId = clientID;
    }

    public void setConsumerName(String consumerName) {
	this.consumerName = consumerName;
    }

    public void setDurable(boolean durable) {
	this.durable = durable;
    }

    public void setMaxiumMessages(int maxiumMessages) {
	this.maxiumMessages = maxiumMessages;
    }

    public void setPauseBeforeShutdown(boolean pauseBeforeShutdown) {
	this.pauseBeforeShutdown = pauseBeforeShutdown;
    }

    public void setPassword(String pwd) {
	this.password = pwd;
    }

    public void setReceiveTimeOut(long receiveTimeOut) {
	this.receiveTimeOut = receiveTimeOut;
    }

    public void setSleepTime(long sleepTime) {
	this.sleepTime = sleepTime;
    }

    public void setSubject(String subject) {
	this.subject = subject;
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

    public void setBatch(long batch) {
	this.batch = batch;
    }
}
