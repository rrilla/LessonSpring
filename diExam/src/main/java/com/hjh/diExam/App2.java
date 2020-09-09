package com.hjh.diExam;

public class App2 {
	
	public static void main(String[] args) {
		MessageFactory factory = MessageFactory.getInstance();
		IMessageBean bean = factory.createMessage("kr");
		bean.sayHello("한재현");
		
		bean = factory.createMessage("en");
		bean.sayHello(" Han Jae Hyeon");
	}

}
