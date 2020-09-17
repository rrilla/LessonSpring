package org.hjh.boardex001.service;

import java.util.List;

import org.hjh.boardex001.domain.ReplyVO;
import org.hjh.boardex001.mapper.BoardMapper;
import org.hjh.boardex001.mapper.ReplyMapper;
import org.hjh.boardex001.util.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Service
@AllArgsConstructor
@Log
public class ReplyServiceImpl implements ReplyService {

	private ReplyMapper replyMapper;
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		boardMapper.replyCount(1, vo.getBno());
		return replyMapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		return replyMapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		return replyMapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(Long rno) {
		ReplyVO vo = replyMapper.read(rno);
		boardMapper.replyCount(-1, vo.getBno());
		return replyMapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		return replyMapper.getList(cri, bno);
	}

}
