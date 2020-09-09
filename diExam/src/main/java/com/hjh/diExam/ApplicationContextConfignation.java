package com.hjh.diExam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfignation {
	@Bean
	public IMessageBean mgsBean() {
		return new MessageBean();
	}
	@Bean
	public IMessageBean msgBeanKr() {
		return new MessageBeanKr();
	}
}
