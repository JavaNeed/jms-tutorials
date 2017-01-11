package com.shengwang.demo;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void send(String text){
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage createTextMessage = session.createTextMessage();
				createTextMessage.setJMSReplyTo(new ActiveMQQueue("Recv2Send"));
				
				return createTextMessage;
			}
		});
	}
	
	public void sendText(final String text){
		jmsTemplate.convertAndSend(text);
	}
	
	public void send(Destination destination, final String text){
		jmsTemplate.send(destination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage createTextMessage = session.createTextMessage(text);
				return createTextMessage;
			}
		});
	}
}
