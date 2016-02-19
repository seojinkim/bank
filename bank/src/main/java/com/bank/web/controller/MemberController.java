package com.bank.web.controller;

import java.util.Scanner;

import com.bank.web.domain.MemberBean;
import com.bank.web.service.MemberService;
import com.bank.web.serviceImpl.MemberServiceImpl;

public class MemberController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MemberService service = new MemberServiceImpl();
		
		while (true) {
			System.out.println("=== 업무선택 ===\n" 
							+ "1.회원가입\n" 
							+ "2.아이디로 회원정보 검색\n" 
							+ "3.이름으로 회원정보 검색\n" 
							+ "4.회원 탈퇴\n"
							+ "5.회원 수\n" 
							+ "6.이름으로 회원수 검색\n" 
							+ "9.종료");

			switch (scanner.nextInt()) {
			case 1:
				System.out.println("아이디: ");
				String userId = scanner.next();
				System.out.println("이름: ");
				String name = scanner.next();
				System.out.println("비밀번호: ");
				String password = scanner.next();
				System.out.println("주소: ");
				String addr = scanner.next();
				System.out.println("생년월일(YYYYMMDD): ");
				int birth = scanner.nextInt();
				System.out.println(service.join(new MemberBean(userId, name, password, addr, birth)));
				break;
			case 2:
				System.out.println("회원정보 검색할 아이디: ");
				System.out.println(service.searchById(scanner.next()));
				break;
			case 3:
				System.out.println("회원정보 검색할 이름: ");
				System.out.println(service.searchByName(scanner.next()).toString());
				break;
			case 4:
				System.out.println("회원 탈퇴할 아이디: ");
				System.out.println(service.remove(scanner.next()));
				break;
			case 5:
				System.out.println("총 회원의 수는 " + service.countAll() + "입니다.");
				break;
			case 6:
				System.out.println("회원수 검색할 이름");
				System.out.println("검색된 회원의 수는 " + service.searchCountByName(scanner.next()) + "입니다.");
				break;
			case 9:
				return;
			default:
				System.out.println("1 ~ 6번 사이에서 선택 가능합니다.");
				System.out.println("다시 선택해 주세요");
				break;
			}
		}
	}
}
