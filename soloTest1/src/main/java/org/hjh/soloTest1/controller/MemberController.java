package org.hjh.soloTest1.controller;

import org.hjh.soloTest1.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

	private MemberService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("getList!!!!!!");
		model.addAttribute("list", service.getList());
	}
}
