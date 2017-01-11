package com.shengwang.demo;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoSenderMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
		JmsMessageSender jmsMessageSender = (JmsMessageSender) ctx.getBean("jmsMessageSender");
		
		// send to default destination 
		jmsMessageSender.send("Hello World !, How're you today ??");
		System.out.println("send to default destination successfully");
		
		// send to a code specified destination
		Queue queue = new ActiveMQQueue("AnotherDest");
		jmsMessageSender.send(queue, "hello Another Message");
		System.out.println("send to specified destination successfully");
		
		// close spring application context
	    ((ClassPathXmlApplicationContext)ctx).close();
	}
}
