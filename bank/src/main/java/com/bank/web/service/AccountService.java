package com.bank.web.service;

import com.bank.web.domain.AccountVO;

public interface AccountService {
	// Database 에서 CRUD
	// create
	// read
	// update
	// delete
	public AccountVO getAccount(String userid);
	
	// 2. 입금
	public String deposit(int money);
	// 3. 출금
	public String withdraw(int money);
	// 4. 잔액조회
	public String search();
}
