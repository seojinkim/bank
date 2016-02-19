package com.bank.web.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.web.domain.MemberBean;
import com.bank.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	Map<String, MemberBean> memberMap;

	public MemberServiceImpl() {
		memberMap = new HashMap<String, MemberBean>();
	}

	@Override
	public String logIn(String userId, String password) {
		String result = "로그인 실패";
		if (password.equals(memberMap.get(userId).getPassword())) {
			result = "로그인 성공";
		}
		return result;
	}

	@Override
	public String update(MemberBean member) {
		String result = "업데이트 실패";
		if (memberMap.containsKey(member.getUserId())) {
			memberMap.put(member.getUserId(), member);
			result = "업데이트 성공";
		}
		return result;
	}

	@Override
	public String join(MemberBean member) {
		// 회원가입
		String result = "회원가입 실패";
		if (!memberMap.containsKey(member.getUserId())) {
			memberMap.put(member.getUserId(), member);
			result = "회원가입 성공";
		}
		return result;
	}

	@Override
	public MemberBean searchById(String id) {
		// 아이디로 회원정보 검색
		return memberMap.get(id);
	}

	@Override
	public List<MemberBean> searchByName(String name) {
		// 이름으로 회원정보 검색
		List<MemberBean> tmpMemList = new ArrayList<MemberBean>();
		for (String key : memberMap.keySet()) {
			if (name.equals(memberMap.get(key).getName())) {
				tmpMemList.add(memberMap.get(key));
			}
		}
		memberMap.entrySet();
		return tmpMemList;
	}

	@Override
	public String remove(String userId) {
		// 회원 탈퇴
		String result = "탈퇴 실패";
		if (memberMap.remove(userId) != null) {
			result = "탈퇴 성공";
		}
		return result;
	}

	@Override
	public int countAll() {
		// 회원 수
		//return memberList.size();
		return memberMap.size();
	}

	@Override
	public int searchCountByName(String name) {
		//이름으로 회원수 검색
		int idx = 0;
		for (String key : memberMap.keySet()) {
			if (name.equals(memberMap.get(key).getName())) {
				idx++;
			}
		}
		return idx;
	}

}
