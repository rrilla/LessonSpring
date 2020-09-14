package com.hjh.ex003.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hjh.ex003.vo.Member;

@Controller
@RequestMapping("/member")
//특정 uri에 대한 처리를 하라

public class MyController {
	
	//@RequestMapping(value="/login", method = RequestMethod.GET)
	//@GetMapping("login")
	
//	@PostMapping("/login")
//	public String login(Model model) {
//		model.addAttribute("id", "abcd");
//		model.addAttribute("pw", "1234");
//		return "member/login";
//	}

//	@PostMapping("/login")
//	public ModelAndView login(HttpServletRequest request) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("id", request.getParameter("id"));
//		mv.addObject("pw", request.getParameter("pw"));
//		mv.setViewName("member/login");
//		return mv;
//	}
	
//	@GetMapping("/login1")
//	public String login(HttpServletRequest request, Model model) {
//		model.addAttribute("id", request.getParameter("id"));
//		model.addAttribute("pw", request.getParameter("pw"));
//		return "member/login";
//	}
	
	@PostMapping("loginPro")
	public String loginPro(HttpServletRequest request, RedirectAttributes rttr) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id.equals("abcd") && pw.equals("1234")) {
			rttr.addFlashAttribute("id", id);
			rttr.addFlashAttribute("pw", pw);
			return "redirect:loginOK";
		}else {
			return "redirect:error";
		}
	}
	
	@GetMapping("/error")
	public String error() {
		return "member/error";
	}
	
//	@GetMapping("/loginOK")
//	public String loginOK() {
//		return "member/login";
//	}
	
	@GetMapping("/loginOK")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
	//public String login(@ModelAttribute("id") String id, @ModelAttribute("pw") String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "member/login";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "member/loginForm";
	}
	
//	@GetMapping("/voMember")
//	public String voMember(HttpServletRequest request, Model model) {
//		Member member = new Member();
//		member.setId(request.getParameter("id"));
//		member.setPw(request.getParameter("pw"));
//		member.setAge(Integer.parseInt(request.getParameter("age")));
//		model.addAttribute("member",member);
//		return "member/voMember";
//	}
	
//	@GetMapping("/voMember")
//	public String voMember(Member member) {
//		//넘어오는 데이터 모델에 넣어서 뷰로 바로보냄
//		return "member/voMember";
//	}
	
	@GetMapping("/voMember")
	public String voMember(@ModelAttribute("m") Member m) {
		//넘어오는 데이터 모델에 넣어서 뷰로 바로보냄
		return "member/voMember";
	}
	
}


