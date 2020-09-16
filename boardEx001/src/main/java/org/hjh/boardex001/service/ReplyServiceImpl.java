package org.hjh.boardex001.service;

import java.util.List;

import org.hjh.boardex001.domain.ReplyVO;
import org.hjh.boardex001.mapper.BoardMapper;
import org.hjh.boardex001.mapper.ReplyMapper;
import org.hjh.boardex001.util.Criteria;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Service
@AllArgsConstructor
@Log
public class ReplyServiceImpl implements ReplyService {

	private ReplyMapper replyMapper;
	
	@Override
	public int register(ReplyVO vo) {
		return replyMapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

}
