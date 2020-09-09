package com.hjh.diexam02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;

import com.hjh.diexam02_3.Member;

//생성시 자동으로 인식함 @Configuration
public class ApplicationContextConfiguration {
	
	@Bean
	public Person p1() {
		Person p1 = new Person("홍길동", 20, "남자");
		return p1;
	}
	
	@Bean
	public Person p2() {
		Person p2 = new Person();
		p2.setName("이하윤");
		p2.setAge(25);
		p2.setGender("남자");
		return p2;
	}
	
	@Bean
	public Member mem1() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList(Arrays.asList("수영", "게임", "낚시"));
		arr.add(0, "수영");
		arr.add(1, "게임");
		arr.add(2, "낚시");
		
		Member m1 = new Member("홍길동", "010-", "남자", arr2);
		return m1;
	}
	
	@Bean
	public Member mem2() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(0, "공부");
		arr.add(1, "자바");
		arr.add(2, "독서");
		arr.add(3, "운동");
		
		Member m1 = new Member("한재현", "010-6422-2642", "남자", arr);
		return m1;
	}
	
}
