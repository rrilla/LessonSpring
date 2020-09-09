package com.hjh.diExam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationContextConfignation.class);
		
		IMessageBean bean=ctx.getBean("messageBean", IMessageBean.class);
		bean.sayHello("홍길동");
		bean=ctx.getBean("messageBeanKr", IMessageBean.class);
		bean.sayHello("홍길동");

	}

}
