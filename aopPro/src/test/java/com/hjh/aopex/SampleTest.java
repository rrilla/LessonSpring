package com.hjh.aopex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hjh.aopex.service.SampleService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTest {
	@Setter(onMethod_=@Autowired)
	private SampleService service;
	
	@Test
	public void testClass() {
		log.info(service);
		log.info(service.getClass());
	}
	
	@Test
	public void testStr() throws Exception{
		log.info(service.doStr());
	}
	
	@Test
	public void testAdd() throws Exception{
		log.info(service.doAdd("123", "123"));
	}
	
	//@Test
	public void testException() throws Exception{
		log.info(service.doAdd("123", "abc"));
	}

	
}










