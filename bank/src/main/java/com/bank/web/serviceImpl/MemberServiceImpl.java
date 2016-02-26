package com.bank.web.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.web.domain.MemberVO;
import com.bank.web.mapper.MemberMapper;
import com.bank.web.service.MemberService;

import java.util.Map.Entry;
@Service
public class MemberServiceImpl implements MemberService{
	// 필드
	@Autowired MemberVO member;
	private MemberVO[] memberList;
	private Map<String,MemberVO> map; // Map 은 인터페이스
	@Autowired private SqlSession sqlSession;
	public MemberServiceImpl() {
		
		map = new HashMap<String,MemberVO>();
	}
	
	// 에어리어
	@Override
	public MemberVO login(MemberVO member) {
		MemberVO temp = new MemberVO();
		if (sqlSession == null) {
			System.out.println("세션이 널값입니다");
		} else {
			System.out.println("세션이 널이 아닙니다");
		}
		System.out.println("파라미터 아이디 : "+member.getUserid());
		System.out.println("파라미터 비번 : "+member.getPassword());
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		temp = mapper.selectMember(member);
		System.out.println("DB에서 서비스로 출력된 회원정보 : "+temp.getName());
		return temp;
	}

	@Override
	public int updateMember(MemberVO member) {
		//map.replace(member.getUserid(), member);
		System.out.println("서비스 멤버2 :"+member.getUserid());
		if (sqlSession == null) {
			System.out.println("수정 세션이 널값입니다");
		} else {
			System.out.println("수정 세션이 널이 아닙니다");
		}
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		int result = mapper.updateMember(member);
		System.out.println("수정 결과 : "+result);
		return result;
	}
	@Override
	public int join(MemberVO member) {
		// 회원가입
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.insertMember(member);
	}

	@Override
	public MemberVO searchById(String id) {
		// 아이디로 회원정보 검색
		return  map.get(id);
	}

	@Override
	public List<MemberVO> searchByName(String name) {
		List<MemberVO> temp = new ArrayList<MemberVO>();
		for (String id : map.keySet()) {
			if (map.get(id).getName().equals(name)) {
				temp.add(map.get(id));
			}
		}
		return temp;
	}

	@Override
	public int remove(String id) {
		// 회원 탈퇴
		// return map.remove(id) != null ?  "탈퇴 성공" : "탈퇴 실패";
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.deleteMember(id);
	}

	@Override
	public int countAll() {
		// 회원수 구하기
		return map.size();
	}

	@Override
	public int searchCountByName(String name) {
		// 이름으로 회원 수 세기
		int n=0;
		for (int i = 0; i < map.size(); i++) {
			if (memberList[i].getName().equals(name)) {
				n++;
			}
		}
		return n;
	}
	@Override
	public String existCheck(String userid) {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.selectUserid(userid);
	}

}
/*
if (map.containsKey(id)) { // 맵에 id 가 존재하는지를 먼저 체크한다
	// 메소드 체인 기법
	result = (map.get(id).getPassword().equals(pass)) ?
			"로그인 성공"
			: "비밀번호가 일치하지 않습니다.";
} else {
	result = "아이디가 존재하지 않거나, 잘못된 아이디 입니다.";
}
*/