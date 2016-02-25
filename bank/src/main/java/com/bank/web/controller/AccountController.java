package com.bank.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bank.web.domain.MemberVO;

@Controller
@RequestMapping("/account")
public class AccountController {
	@RequestMapping(value = "/myaccount", method = RequestMethod.GET)
	public String loginForm(Model model, HttpSession session) {
		MemberVO temp = new MemberVO();
		temp = (MemberVO) session.getAttribute("member");
		model.addAttribute("message", temp.getName());
		model.addAttribute("userid", temp.getUserid());
		return "account/myaccount";
	}
}
