package com.bank.web.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;

import com.bank.web.domain.MemberVO;
import com.bank.web.service.MemberService;
import com.bank.web.serviceImpl.MemberServiceImpl;
@Controller
public class MemberController2 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		MemberService member= new MemberServiceImpl();
		MemberVO mem = null;
		
		
		 while (true) {
			 
			 
			System.out.println("[메뉴]"
					+ "\n0.가입하기"
					+ "\n1.아이디로 회원정보검색"
					+ "\n2.이름으로 회원정보검색"
					+ "\n3.회원 수 세기"
					+ "\n4.이름으로 회원 수 세기"
					+ "\n5.탈퇴시키기 ");
			
			switch (scanner.nextInt()) {
	         		
			case 0:
				System.out.println("가입하시려면 id,password,name,address,birth입력하세요.");
				
				mem=new MemberVO();
				mem.setUserid(scanner.next());
				mem.setPassword(scanner.next());
				mem.setName(scanner.next());
				mem.setAddr(scanner.next());
				mem.setBirth(scanner.nextInt());
				System.out.println(member.join(mem));
				
				break;
				
				
			case 1:
			System.out.println("아이디를 입력하세요: ");
			System.out.println("회원정보는 "+member.searchById(scanner.next()).toString());
			break;
			
			case 2:
				System.out.println("이름을 입력하세요: ");
				List<MemberVO> temp = member.searchByName(scanner.next());
					System.out.println("회원정보는 "+temp);
				break;
			case 3:
				System.out.println("총 회원 수는 "+member.countAll());
				
				break;
			case 4:
				System.out.println("이름을 입력하세요: ");
				System.out.println("입력한 이름을 가진 회원 수는 "
						+member.searchCountByName(scanner.next()));
				break;
				
			case 5:
				System.out.println("삭제하고 싶은 회원의 아이디는: ");
				System.out.println(member.remove(scanner.next()));
			default:
				break;
			}
			
		}
	}
}
