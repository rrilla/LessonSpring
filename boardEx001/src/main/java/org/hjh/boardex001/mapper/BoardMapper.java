package org.hjh.boardex001.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.hjh.boardex001.domain.BoardVo;

public interface BoardMapper {
	
	@Select("select * from board where bno > 0")
//	@Delete("delete from board where bno = 2")
//	@Insert("insert into board values")
	public List<BoardVo> getList();
}
