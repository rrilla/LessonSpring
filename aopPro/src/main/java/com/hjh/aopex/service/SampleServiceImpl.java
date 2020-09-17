package com.hjh.aopex.service;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}

	@Override
	public String doStr() {
		return "Hello world!";
	}

}
