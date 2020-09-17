package org.hjh.boardex001.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hjh.boardex001.domain.BoardVo;
import org.hjh.boardex001.util.Criteria;

public interface BoardMapper {
	
	//짧은 쿼리 이용시, 긴쿼리 = mybatis 매핑
	//@Select("select * from board where bno > 0")
//	@Delete("delete from board where bno = 2")
//	@Insert("insert into board values")
	public List<BoardVo> getList();
	public List<BoardVo> getListWithPaging(Criteria cri);
	public void insert(BoardVo board);
	
	//시퀀스로 no 생성시, insert하기 전 no값을 얻고 싶을때 사용. 
	public void insertSelectKey(BoardVo board);
	
	public List<BoardVo> selectNo(int n);
	public BoardVo read(Long bno);
	public int update(BoardVo board);
	public int delete(Long bno);
	public int totalCount(Criteria cri);
	public int readCount(Long bno);
	public int replyCount(@Param("amount") int amount, @Param("bno") Long bno);
}
