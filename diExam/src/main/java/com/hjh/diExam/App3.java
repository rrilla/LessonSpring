package com.hjh.diExam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean1.xml");
		IMessageBean bean = ctx.getBean("msg1", MessageBean.class);
		bean.sayHello("한재현");
		bean = ctx.getBean("msgKr",IMessageBean.class);
		bean.sayHello("한재현");
	}

}
