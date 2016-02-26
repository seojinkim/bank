package com.bank.web.service;

import java.util.List;

import com.bank.web.domain.MemberVO;

public interface MemberService {
	public int join(MemberVO member);
	public MemberVO searchById(String id);
	public List<MemberVO> searchByName(String name);
	public int remove(String id); 
	public int countAll();
	public int searchCountByName(String name);
	public MemberVO login(MemberVO member);
	public int updateMember(MemberVO member);
	public String existCheck(String userid);
}
