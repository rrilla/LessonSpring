package com.hjh.ex003.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String pw;
	private int age;
	@DateTimeFormat(pattern="yy-MM-dd")
	private Date regDate;
}
