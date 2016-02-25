package com.bank.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bank.web.domain.MemberVO;
import com.bank.web.serviceImpl.MemberServiceImpl;

@Controller
@SessionAttributes("member")
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberVO member;
	@Autowired
	MemberServiceImpl service;

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm(Model model) {

		return "member/loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam("userid")   String userid, 
						@RequestParam("password") String password,
												  HttpSession session,
												  Model model) {

		System.out.println("넘어온 아이디 " + userid);
		System.out.println("넘어온 비밀번호 " + password);

		MemberVO member = new MemberVO();
		String existId  = service.existCheck(userid);
		String message  = "", page = "";

		if (existId == null) {
			message = "아이디가 존재하지 않습니다";
			page = "member/loginForm";
		} else {
			member.setUserid(userid);
			member.setPassword(password);
			member = service.login(member);

			if (member == null) {
				message = "아이디와 비번이 다릅니다";
				page = "member/loginForm";
			} else {
				message = member.getName();
				page = "account/myaccount";
			}
			session.setAttribute("member", member);
			model.addAttribute("message", message);
		}
		return page;
	}

	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(Model model) {

		return "member/joinForm";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(@RequestParam("userid")   String userid,
					   @RequestParam("password") String password,
					   @RequestParam("name")     String name, 
					   @RequestParam("addr")     String addr, 
					   @RequestParam("birth")    String birth,
					   						     Model  model) {

		member.setUserid(userid);
		member.setPassword(password);
		member.setName(name);
		member.setAddr(addr);
		member.setBirth(Integer.parseInt(birth));
		// String 타입을 int 타입으로 변환 => Integer.parseInt()
		// String.valueOf() => int 타입을 String 타입으로 변환
		System.out.println("1111111111111111111111111111111111111");
		int result = service.join(member);
		if (result == 1) {
			model.addAttribute("name", name);
		} else {
			System.out.println("회원가입 실패");
		}
		return "member/loginForm";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
		return "global/home";
	}
	
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm() {
		return "member/updateForm";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("password") String password,
						 @RequestParam("addr") 	   String addr,
						 						   HttpSession session,
						 						   Model model) {
		
		System.out.println("update 메소드 진입");
		MemberVO temp = new MemberVO();
		temp = (MemberVO) session.getAttribute("member");
		member.setUserid(temp.getUserid());
		member.setPassword(password);
		member.setAddr(addr);

		int result = service.update(member);
		String page = "";
		if (result == 1) {
			temp.setPassword(password);
			temp.setAddr(addr);
			session.setAttribute("member", temp);
			page = "member/detail";
		} else {
			System.out.println("회원 수정 실패");
			page = "member/updateForm";
		}

		return page;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail() {
		
		return "member/detail";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(HttpSession session, SessionStatus status) {
		MemberVO temp = new MemberVO();
		temp = (MemberVO) session.getAttribute("member");
		String userid = temp.getUserid();
		
		int result = service.remove(userid);
		String page = "";
		if (result == 1) {
			System.out.println("DELETE SUCCESS");
			status.setComplete();
			page = "global/home";
		} else {
			System.out.println("DELETE FAIL");
			page = "account/myaccount";
		}
		return page;
	}
}