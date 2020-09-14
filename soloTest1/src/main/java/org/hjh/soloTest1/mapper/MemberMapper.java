package org.hjh.soloTest1.mapper;

import java.util.List;

import org.hjh.soloTest1.domain.MemberVo;


public interface MemberMapper {

	public List<MemberVo> getList();
	public void insert(MemberVo member);
	public void insertSelectKey(MemberVo member);
	public List<MemberVo> selectNo(int n);
	public MemberVo read(Long no);
	public int update(MemberVo member);
	public int delete(Long no); 
}
