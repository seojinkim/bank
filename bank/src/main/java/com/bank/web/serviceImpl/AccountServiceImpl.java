package com.bank.web.serviceImpl;

import com.bank.web.domain.AccountBean;
import com.bank.web.service.AccountService;

public class AccountServiceImpl implements AccountService {
	AccountBean account = new AccountBean();

	@Override
	public String open(String name, int password) {
		account.setName(name);
		account.setPassword(password);
		return account.toString();
	}

	@Override
	public String deposit(int money) {
		account.setMoney(account.getMoney() + money);
		return account.toString();
	}

	@Override
	public String withdraw(int money) {
		//3. 출금 ALT + SHIFT + M : 메소드로 추출하는 단축키
		return (account.getMoney() >= money) ? this.saveMoney(money) : "잔액 부족";
	}

	private String saveMoney(int money) {
		String result;
		account.setMoney(account.getMoney() - money);
		result = "잔액 : " + account.getMoney();
		return result;
	}

	@Override
	public String search() {
		return account.toString();
	}
}
