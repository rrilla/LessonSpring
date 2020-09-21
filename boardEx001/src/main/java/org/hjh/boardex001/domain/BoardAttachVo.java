package org.hjh.boardex001.domain;

import lombok.Data;

@Data
public class BoardAttachVo {
	private String uuid;
	private String uploadPath;
	private String filename;
	private boolean filetype;
	private Long bno;
}
