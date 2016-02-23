package com.bank.web.domain;

import org.springframework.stereotype.Component;

@Component
public class MemberVO {

	private String userid;
	private String name;
	private String password;
	private String addr;
	private int birth;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		return "userid=" + userid + " / name=" + name + " / password=" + password + " / addr=" + addr
				+ " / birth=" + birth;
	}
	
	
}
