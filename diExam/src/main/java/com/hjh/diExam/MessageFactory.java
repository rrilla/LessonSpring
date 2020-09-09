package com.hjh.diExam;

public class MessageFactory {
	private MessageFactory() {}
	private static MessageFactory factory = new MessageFactory();
	
	public static MessageFactory getInstance() {
		return factory;
	}
	
	public IMessageBean createMessage(String str) {
		if(str.equals("kr")) {
			return new MessageBeanKr();
		}else {
			return new MessageBean();
		}
	}

}
