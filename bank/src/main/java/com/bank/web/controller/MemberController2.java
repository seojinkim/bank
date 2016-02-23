package com.bank.web.controller;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import com.bank.web.domain.MemberVO;
import com.bank.web.service.MemberService;
import com.bank.web.serviceImpl.MemberServiceImpl;

@Controller
public class MemberController2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MemberService service = new MemberServiceImpl();
		MemberVO member = null;

		while (true) {
			System.out.println("[업무선택]\n"
					+ "1. 회원 가입\n"
					+ "2. 아이디로 회원정보 검색\n"
					+ "3. 이름으로 회원정보 검색\n"
					+ "4. 회원 탈퇴\n"
					+ "5. 전체 조회\n"
					+ "6. 이름으로 가입된 아이디 검색\n"			
					+ "9. 종료");
			
			switch (sc.nextInt()) {
			case 1:
				System.out.println("아이디, 이름, 비밀번호, 주소, 생일 :");
				member = new MemberVO();
				member.setUserid(sc.next());
				member.setName(sc.next());
				member.setPassword(sc.next());
				member.setAddr(sc.next());
				member.setBirth(sc.nextInt());
				
				System.out.println("[가입완료] " + service.join(member));
				break;
			case 2:		
				System.out.println("아이디 입력 :");
				System.out.println("[정보조회] " + service.searchById(sc.next()).toString());
				break;
			case 3:
				System.out.println("이름 입력 :");
				MemberVO[] members = service.searchByName(sc.next());
				for (int i = 0; i < members.length; i++) {
					System.out.println("[정보조회] " + members[i]);
				}
				break;
			case 4:
				System.out.println("삭제하려는 아이디 입력 :");
				System.out.println("[회원탈퇴] " + service.remove(sc.next()));
				break;
			case 5:
				System.out.println("[전체조회] " + service.countAll() + "(명)");
				break;
			case 6:break;
			case 9:return;

			default:
				System.out.println("1~9번 사이에서 선택가능합니다.");
				System.out.println("다시 선택해 주세요");
				break;
			}
		}
	
	}
}
