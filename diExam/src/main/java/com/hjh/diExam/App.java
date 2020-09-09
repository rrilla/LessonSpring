package com.hjh.diExam;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IMessageBean bean = new MessageBean();
		bean.sayHello("홍길동");
		bean = new MessageBeanKr();
		bean.sayHello("홍길동");
	}

}
