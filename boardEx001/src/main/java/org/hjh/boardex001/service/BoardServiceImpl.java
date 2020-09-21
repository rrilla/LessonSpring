package org.hjh.boardex001.service;

import java.util.List;

import org.hjh.boardex001.domain.BoardAttachVo;
import org.hjh.boardex001.domain.BoardVo;
import org.hjh.boardex001.mapper.BoardAttachMapper;
import org.hjh.boardex001.mapper.BoardMapper;
import org.hjh.boardex001.util.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@AllArgsConstructor	//서비스객체 생성시 클래스 안의 필드 자동 생성하여 주입(autowire)
public class BoardServiceImpl implements BoardService {

	private BoardMapper boardMapper;
	private BoardAttachMapper attachMapper;
	
	@Transactional
	@Override
	public void register(BoardVo board) {
		boardMapper.insertSelectKey(board);
		System.out.println("insert test");
		
		if(board.getAttachList() == null || board.getAttachList().size()>=0) {
			return;
		}
		
		board.getAttachList().forEach(attach->{
		attach.setBno(board.getBno());
		System.out.println("insert attach");
		attachMapper.insert(attach);
		});
	}

	@Override
	public BoardVo get(Long bno) {
		boardMapper.readCount(bno);
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

	@Override
	public List<BoardVo> getList(Criteria cri) {
		return boardMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return boardMapper.totalCount(cri);
	}
	
	@Override
	public List<BoardAttachVo> getAttachList(Long bno) {
		// TODO Auto-generated method stub
		log.info("get Attach list by bno" + bno);

		return attachMapper.findByBno(bno);
	}

	@Override
	public void removeAttach(Long bno) {
		// TODO Auto-generated method stub
		log.info("remove all attach files");
		
		attachMapper.deleteAll(bno);
		
		
	}

}
