package org.hjh.boardex001.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.hjh.boardex001.domain.BoardVo;

public interface BoardMapper {
	
	//짧은 쿼리 이용시, 긴쿼리 = mybatis 매핑
	//@Select("select * from board where bno > 0")
//	@Delete("delete from board where bno = 2")
//	@Insert("insert into board values")
	public List<BoardVo> getList();
	public void insert(BoardVo board);
	
	//시퀀스로 no 생성시, insert하기 전 no값을 얻고 싶을때 사용. 
	public void insertSelectKey(BoardVo board);
	
	public List<BoardVo> selectNo(int n);
	
}
