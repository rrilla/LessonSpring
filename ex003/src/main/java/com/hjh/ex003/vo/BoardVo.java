package com.hjh.ex003.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVo {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	@DateTimeFormat(pattern="yy-MM-dd")
	private Date regdate;
	@DateTimeFormat(pattern="yy-MM-dd")
	private Date updateDate;
}
