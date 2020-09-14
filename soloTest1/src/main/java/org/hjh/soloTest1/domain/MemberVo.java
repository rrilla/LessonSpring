package org.hjh.soloTest1.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVo {
	private Long no;
	private String name;
	private String address;
	private String comm;
	private Date join_date;
}
