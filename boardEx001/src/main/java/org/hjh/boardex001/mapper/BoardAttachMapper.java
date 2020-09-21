package org.hjh.boardex001.mapper;

import java.util.List;

import org.hjh.boardex001.domain.BoardAttachVo;

public interface BoardAttachMapper {
	public void insert(BoardAttachVo vo);
	public void delete(String uuid);
	public void deleteAll(Long bno);
	public List<BoardAttachVo> findByBno(Long bno);
}
