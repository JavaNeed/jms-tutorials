package com.shengwang.demo;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JmsMessageListener implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		TextMessage message = (TextMessage) msg;
		try {
			System.out.println(message.getText());  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
