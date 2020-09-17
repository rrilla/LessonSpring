package com.hjh.aopex.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Aspect	//어드바이스 클래스란걸 알려줌.
@Log
@Component
public class LogAdvice {
		
	//서비스 함수 실행 전 이거 먼저 실행.
	@Before("execution(* com.hjh.aopex.service.SampleService*.*(..))")
	public void logBefor() {
		log.info("====================================");
	}
}
