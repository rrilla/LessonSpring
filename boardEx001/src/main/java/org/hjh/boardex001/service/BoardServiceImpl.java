package org.hjh.boardex001.service;

import java.util.List;

import org.hjh.boardex001.domain.BoardVo;
import org.hjh.boardex001.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@AllArgsConstructor	//서비스객체 생성시 클래스 안의 필드 자동 생성하여 주입(autowire)
public class BoardServiceImpl implements BoardService {

	private BoardMapper boardMapper;
	
	@Override
	public void register(BoardVo board) {
		boardMapper.insert(board);
	}

	@Override
	public BoardVo get(Long bno) {
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVo board) {
		int n = boardMapper.update(board);
		if(n == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean remove(Long bno) {
		int n = boardMapper.delete(bno);
		if(n == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<BoardVo> getList() {
		return boardMapper.getList();
	}

}
