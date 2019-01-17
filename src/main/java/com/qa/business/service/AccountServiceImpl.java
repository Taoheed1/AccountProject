package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistance.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String createAccount(String firstName, String lastName, int accountNumber) {
		return repo.createAccount(firstName, lastName, accountNumber);
	}

	@Override
	public String deleteAccount(int accountNumber) {
		return repo.deleteAccount(accountNumber);
	}

	@Override
	public String updateAccount(int accountNumber) {
		// TODO Auto-generated method stub
		return null;
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
