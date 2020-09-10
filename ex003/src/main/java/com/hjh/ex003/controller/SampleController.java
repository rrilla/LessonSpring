package com.hjh.ex003.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjh.ex003.vo.SampleDto;

@Controller
@RequestMapping("/sample")
public class SampleController {

	//void타입 - 호출하는 URL과 동일한 이름의 jsp파일
	@GetMapping("ex01")
	public void dtoview(Model model) {
		SampleDto dto = new SampleDto();
		dto.setAge(20);
		dto.setName("한재현");
		dto.setGender("남자");
		model.addAttribute("dto", dto);
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

	//ResponseEntity - HTTP헤더 정보와 추가적인 데이터를 전달할 때 사용
	@GetMapping("ex07")
	public ResponseEntity<SampleDto> ex07() {
		// {"name": "홍길동"}
		//String msg = "{\"name\": \"홍길동\"}";
		//log.info("/ex07..........");
		SampleDto dto = new SampleDto();
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<SampleDto>(dto, header, HttpStatus.OK);
	}
}
