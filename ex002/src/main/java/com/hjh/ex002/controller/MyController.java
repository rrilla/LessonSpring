package com.hjh.ex002.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/aaa")
	public String aaa() {
		return "aaa";
	}
}
