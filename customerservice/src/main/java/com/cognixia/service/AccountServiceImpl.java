package com.cognixia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognixia.model.Account;

@Component
public class AccountServiceImpl implements AccountService {

	
	public List<Account> findByCutomer(Integer customer) {
		List<Account> defaultList = new ArrayList<>();
		defaultList.add(new Account(0000, 1.000, 0000, "UNKNOWN ACCOUNT TYPE", "UNK", "FALLBACK BANK"));
        return defaultList;
	}

	@Override
	public Account update(Integer accountId, Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
