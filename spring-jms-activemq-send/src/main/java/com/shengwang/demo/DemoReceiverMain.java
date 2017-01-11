package com.shengwang.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoReceiverMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("receiverContext.xml");
	}
}
