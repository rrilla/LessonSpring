package org.hjh.boardex001.service;

import java.util.List;

import org.hjh.boardex001.domain.ReplyVO;
import org.hjh.boardex001.util.Criteria;

public interface ReplyService {
	public int register(ReplyVO vo);
	public ReplyVO get(Long rno);
	public int modify(ReplyVO vo);
	public int remove(Long rno);
	public List<ReplyVO> getList(Criteria cri, Long bno);
}
