package org.hjh.boardex001.service;

import java.util.List;

import org.hjh.boardex001.domain.BoardAttachVo;
import org.hjh.boardex001.domain.BoardVo;
import org.hjh.boardex001.util.Criteria;

public interface BoardService {
	public void register(BoardVo board);
	public BoardVo get(Long bno);
	public boolean modify(BoardVo board);
	public boolean remove(Long bno);
	public List<BoardVo> getList();
	public List<BoardVo> getList(Criteria cri);
	public int getTotal(Criteria cri);
	public List<BoardAttachVo> getAttachList(Long bno);
	public void removeAttach(Long bno);
}
