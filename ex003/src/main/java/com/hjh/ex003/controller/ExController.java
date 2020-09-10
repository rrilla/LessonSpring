package com.hjh.ex003.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hjh.ex003.vo.BoardVo;
import com.hjh.ex003.vo.SampleDto;

@Controller
@RequestMapping("/board")
public class ExController {

	@GetMapping("/join")
	public String joinForm() {
		return "board/joinForm";
	}
	
//	@PostMapping("/joinGo")
//	public String loginPro(HttpServletRequest request, RedirectAttributes rttr) {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		if(id.equals("abcd") && pw.equals("1234")) {
//			rttr.addFlashAttribute("id", id);
//			rttr.addFlashAttribute("pw", pw);
//			return "redirect:loginOK";
//		}else {
//			return "redirect:error";
//		}
//	}
	
	
	@PostMapping("/joinGo")
	public @ResponseBody BoardVo print(BoardVo board) {
		//넘어오는 데이터 모델에 넣어서 뷰로 바로보냄
		//BoardVo vo = board;
		return board;
	}
	
	//객체 타입 - Json으로 처리
		@GetMapping("ex02")
		public @ResponseBody SampleDto dtoview() {
			SampleDto dto = new SampleDto();
			dto.setAge(20);
			dto.setName("한재현");
			dto.setGender("남자");
			return dto;
		}
	
	
}
