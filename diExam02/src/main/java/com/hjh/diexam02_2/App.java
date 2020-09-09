package com.hjh.diexam02_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new 
				ClassPathXmlApplicationContext("student_bean.xml");
		
		Student s1 = ctx.getBean("stud1", Student.class);
		System.out.println(s1);
		Student s2 = ctx.getBean("stud2", Student.class);
		System.out.println(s2);
		
	}
}
