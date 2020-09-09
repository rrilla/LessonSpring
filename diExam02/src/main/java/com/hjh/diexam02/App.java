package com.hjh.diexam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("bean_config.xml");
		//설정 파일로
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
		//컨텍스트로
		
		Person p1 = ctx.getBean("p1", Person.class);
		p1.display();
		
		Person p2 = ctx.getBean("p2", Person.class);
		p2.display();
		
		Person p3 = ctx.getBean("p3", Person.class);
		p3.display();
	}

}
