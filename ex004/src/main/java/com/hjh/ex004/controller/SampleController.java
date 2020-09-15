package com.hjh.ex004.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hjh.ex004.domain.SampleVO;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/sample")
@Log
public class SampleController {
	
	@GetMapping("getStr")
	public String getStr() {
		return "Hello world";
	}
	
//	@GetMapping(value="/getSample",
//			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
//					MediaType.APPLICATION_XML_VALUE})	//default 시 둘다 사용가능, 하나를 명시적 선언시 나머지 사용불가
	@GetMapping("/getSample")
	public SampleVO getSample() {
		return new SampleVO(1, "재현", "한");
	}
	
	@GetMapping("/getList")
	public List<SampleVO> getList(){
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO(1, "하윤", "Lee"));
		list.add(new SampleVO(2, "하윤", "Kim"));
		list.add(new SampleVO(3, "하윤", "Park"));
		list.add(new SampleVO(4, "하윤", "Hong"));
		return list;
	}
	
	@GetMapping("/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("kim", new SampleVO(1, "길동", "Kin"));
		map.put("Lee", new SampleVO(1, "길동", "lee"));
		map.put("Hong", new SampleVO(1, "길동", "Hong"));
		return map;
	

	
}
}