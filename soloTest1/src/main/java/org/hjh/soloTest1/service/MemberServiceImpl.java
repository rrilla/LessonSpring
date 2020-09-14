package org.hjh.soloTest1.service;

import java.util.List;

import org.hjh.soloTest1.domain.MemberVo;
import org.hjh.soloTest1.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

	private MemberMapper memberMapper;
	
	@Override
	public void register(MemberVo member) {
		memberMapper.insert(member);
	}

	@Override
	public MemberVo get(Long no) {
		return memberMapper.read(no);
	}

	@Override
	public boolean modify(MemberVo member) {
		int n = memberMapper.update(member);
		if(n == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean remove(Long no) {
		int n = memberMapper.delete(no);
		if(n == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<MemberVo> getList() {
		return memberMapper.getList();
	}

}
