package com.bank.web.serviceImpl;

import com.bank.web.domain.AccountBean;
import com.bank.web.service.AdminService;

public class AdminServiceImpl implements AdminService {
	private AccountBean[] accountBeans;
	private int count;

	public AdminServiceImpl() {
		count = 0;
		accountBeans = new AccountBean[100];
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String open(String name, int password) {
		// 1.통장개설
		// account 인스턴스를 필드에 선언하면
		// 나중에 추가되는 값을 오버라이딩하게 된다.
		// 추가되는 개념으로 코딩하려면 지역변수로 처리하고
		// 자료구조(컬렉션)을 필드에 선언해야 한다.
		AccountBean account = new AccountBean();
		account.setName(name);
		account.setPassword(password);
		accountBeans[count] = account;
		count++;
		return account.toString();
	}

	@Override
	public int countAll() {
		// 1. 전체 계좌 수 조회
		return count;
	}

	@Override
	public AccountBean searchAccountByAccountNo(int accountNo) {
		AccountBean account = null; // 이 라인에서 account는 인스턴스 개념이 아니라 return을 받는 타입
		for (int i = 0; i < this.getCount(); i++) {
			if (accountBeans[i].getAccountNo() == accountNo) {
				account = accountBeans[i];
				break;
			}
		}
		return account;
	}

	@Override
	public AccountBean[] searchAccountByName(String name) {
		AccountBean[] tempList = new AccountBean[this.searchCountByName(name)];
		int j = 0;
		for (int i = 0; i < this.getCount(); i++) {
			if (accountBeans[i].getName().equals(name)) {
				tempList[j] = accountBeans[i];
				j++;
			}
		}
		return tempList;
	}

	@Override
	public String closeAccount(int accountNo) {
		String result = "";
		if (this.searchAccountByAccountNo(accountNo) != null) {
			for (int i = 0; i < this.getCount(); i++) {
				if (accountBeans[i].getAccountNo() == accountNo) {
					accountBeans[i] = accountBeans[this.getCount() - 1];
					accountBeans[this.getCount() - 1] = null;
					count--;
					result = "삭제 성공";
				}
			}
		} else {
			result = "해당 계좌가 없음";
		}
		return result;
	}

	@Override
	public int searchCountByName(String name) {
		int tempCount = 0;
		for (int i = 0; i < this.getCount(); i++) {
			if (accountBeans[i].getName().equals(name)) {
				tempCount++;
			}
		}
		return tempCount;
	}
}
