package com.bank.web.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.web.domain.MemberVO;
import com.bank.web.mapper.MemberMapper;
import com.bank.web.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	// 필드
	@Autowired
	MemberVO member;
	private MemberVO[] memberList;
	private Map<String, MemberVO> map; // Map은 인터페이스
	@Autowired
	private SqlSession sqlSession;

	public MemberServiceImpl() {
		map = new HashMap<String, MemberVO>();
	}

	public MemberVO[] getMemberList() {
		return memberList;
	}

	public void setMemberList(MemberVO[] memberList) {
		this.memberList = memberList;
	}

	@Override
	public MemberVO login(MemberVO member) {
		// 로그인
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		member = mapper.selectMember(member);

		return member;
	}

	@Override
	public int update(MemberVO member) {
		// 정보수정
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

		return mapper.update(member);
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
		return map.get(id);
	}

	@Override
	public String existCheck(String userid) {
		// TODO Auto-generated method stub
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.selectUserid(userid);
	}

	@Override
	public MemberVO[] searchByName(String name) {
		// 이름으로 회원정보 검색
		MemberVO[] tempList = new MemberVO[this.searchCountByName(name)];
		int j = 0;

		for (int i = 0; i < map.size(); i++) {
			if (map.get(i).getName().equals(name)) {
				tempList[j] = map.get(i);
				j++;
			}
		}
		return tempList;
	}

	@Override
	public int remove(String userid) {
		// 회원 탈퇴
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return mapper.deleteMember(userid);
	}

	@Override
	public int countAll() {
		// 전체 회원 수 조회
		return map.size();
	}

	@Override
	public int searchCountByName(String name) {
		// 이름으로 가입된 아이디 검색
		int tempCount = 0;

		for (int i = 0; i < map.size(); i++) {
			if (memberList[i].getName().equals(name)) {
				tempCount++;
			}
		}

		return tempCount;
	}

}
