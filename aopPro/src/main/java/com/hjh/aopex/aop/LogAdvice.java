package com.hjh.aopex.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Aspect	//어드바이스 클래스란걸 알려줌.
@Log
@Component
public class LogAdvice {
		
	//서비스 함수 실행 전 이거 먼저 실행.포인트컷
	@Before("execution(* com.hjh.aopex.service.SampleService*.*(..))")
	public void logBefor() {
		log.info("====================================");
	}
	
	//(적용 범위) - 서비스에 있는 모든 함수.
	@Before("execution(* com.hjh.aopex.service.SampleService*.doAdd(String, String))&& args(str1,str2)")
	public void logBeforWithParam(String str1, String str2) {
		log.info("str1:" + str1);
		log.info("str2:" + str2);
	}
	
	@AfterThrowing(pointcut="execution(* com.hjh.aopex.service.SampleService*.*(..))",
			throwing="exception")
	public void logException(Exception exception) {
		log.info("Exception...!!!!!!!!!");
		log.info("Exception:" + exception);
	}
	
	@Around("execution(* com.hjh.aopex.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		log.info("start:" + start);
		
		log.info("Target:" + pjp.getTarget());
		log.info("param:" + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		
		try {
			result = pjp.proceed();
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		log.info("end:" + end);
		log.info("Time : " + (end-start));
		return result;
	}
	
}
