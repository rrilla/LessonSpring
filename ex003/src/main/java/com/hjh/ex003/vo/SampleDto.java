package com.hjh.ex003.vo;

import lombok.Data;

@Data
public class SampleDto {
	private String name;
	private int age;
	private String gender;
	@Override
	public String toString() {
		return "SampleDto [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}
