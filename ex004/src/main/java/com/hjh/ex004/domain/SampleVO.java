package com.hjh.ex004.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor	//필드값 모두 가지는 생성자 생성 - default 생성자 사라짐
@NoArgsConstructor	//default 생성자 생성
public class SampleVO {
	private Integer mno;
	private String firstName;
	private String lastName;
}
