package com.bank.web.domain;

public class MemberBean {
	private String userId;
	private String name;
	private String password;
	private String addr;
	private int birth;

	public MemberBean() {
	}

	public MemberBean(String userId, String name, String password, String addr, int birth) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.addr = addr;
		this.birth = birth;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "MemberBean [userId=" + userId + ", name=" + name + ", password=" + password + ", addr=" + addr
				+ ", birth=" + birth + "]\n";
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
}
