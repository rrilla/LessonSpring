package com.hjh.diexam02_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {
	@Autowired
	private TestB b;
	@Autowired
	private TestC c;
	
//	@Autowired
//	public void setB(TestB b) {
//		this.b = b;
//	}
//	@Autowired
//	public void setC(TestC c) {
//		this.c = c;
//	}
	public static void main(String[] args) {
		ApplicationContext ctx = new
				ClassPathXmlApplicationContext("test_bean.xml");
		TestA bean = ctx.getBean("testa", TestA.class);
		bean.b.display();
		bean.c.display();
	}
}
