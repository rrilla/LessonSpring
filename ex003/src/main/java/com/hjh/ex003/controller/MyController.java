package com.hjh.ex003.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")

public class MyController {
	
	//@RequestMapping(value="/login", method = RequestMethod.GET)
	//@RequestMapping("login")
	
//	@PostMapping("/login")
//	public String login(Model model) {
//		model.addAttribute("id", "abcd");
//		model.addAttribute("pw", "1234");
//		return "member/login";
//	}

	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", request.getParameter("id"));
		mv.addObject("pw", request.getParameter("pw"));
		mv.setViewName("member/login");
		return mv;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "member/loginForm";
	}
}
