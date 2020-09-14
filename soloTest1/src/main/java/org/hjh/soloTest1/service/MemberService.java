package org.hjh.soloTest1.service;

import java.util.List;

import org.hjh.soloTest1.domain.MemberVo;


public interface MemberService {
	public void register(MemberVo member);
	public MemberVo get(Long no);
	public boolean modify(MemberVo member);
	public boolean remove(Long no);
	public List<MemberVo> getList();
}
