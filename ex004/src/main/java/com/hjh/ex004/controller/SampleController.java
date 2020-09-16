package com.hjh.ex004.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hjh.ex004.domain.SampleVO;
import com.hjh.ex004.domain.Ticket;

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
	
	//ResponseEntity : 브라우저에 데이터 + HTTP상태  코드 등 추가적으로 전달 가능.
	//http://localhost:8095/ex004/sample/check?height=140&weight=40
	@GetMapping(value="/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(000, "" + height, "" + weight);
		ResponseEntity<SampleVO> result = null;
		if(height < 150)
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		else
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		return result;
	}
	
	//PathVariable : URL경로 중간에 들어간 값을 얻기 위해 사용
	//http://localhost:8095/ex004/sample/product/zz/2323    //cat=zz, pid=2323
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(
		@PathVariable("cat") String cat,
		@PathVariable("pid") Integer pid){
		return new String[] {"category : " + cat, "productid : " + pid};
		}
	
	//RequestBody : json데이터 얻어올 때
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert....ticket" + ticket);
		return ticket;
	}
}