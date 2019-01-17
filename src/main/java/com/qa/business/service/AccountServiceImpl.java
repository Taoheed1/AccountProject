package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistance.repository.AccountRepository;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String createAccount(Account account) {
		if (account.getAccountNumber() == 999) {
			return "{\"message\": \"this account it blocked\"}";
		} else {
			return repo.createAccount(account);
		}
	}

	@Override
	public String deleteAccount(int accountNumber) {
		return repo.deleteAccount(accountNumber);
	}

	@Override
	public String updateAccount(int accountNumber, Account account) {
			//String updateField, String userInput) {
		// TODO Auto-generated method stub
		return repo.updateAccount(accountNumber, account);
		//, updateField, userInput);
	}
	//
	// @Override
	// public String firstNameSearch(String firstName) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public String lastNameSearch(String lastName) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
