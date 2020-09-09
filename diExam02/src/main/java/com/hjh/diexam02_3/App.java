package com.hjh.diexam02_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hjh.diexam02.ApplicationContextConfiguration;
import com.hjh.diexam02_2.Student;

public class App {
	public static void main(String[] args) {
//		ApplicationContext ctx = new 
//				ClassPathXmlApplicationContext("member_bean.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
		
		Member m1 = ctx.getBean("mem1", Member.class);
		m1.print();
		Member m2 = ctx.getBean("mem2", Member.class);
		m2.print();
	}
}
