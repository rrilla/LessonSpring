package org.hjh.boardex001.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hjh.boardex001.domain.ReplyVO;
import org.hjh.boardex001.util.Criteria;

public interface ReplyMapper {
	public int insert(ReplyVO vo);
	public ReplyVO read(Long rno);
	public int delete(Long rno);
	public int update(ReplyVO vo);
	
	//파라메타를 매퍼에 보낼 땐 한덩어리만(객체,map,@param(파라메타객체 만들어 넣는것)) 가능  : map형으로 보내는
	public List<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno")Long bno);
	
}
