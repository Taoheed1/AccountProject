package com.qa.business.service;

import com.qa.persistence.domain.Account;

public interface AccountService {

	String createAccount(Account account);

	String getAllAccounts();

	String deleteAccount(int accountNumber);

	String updateAccount(int accountNumber, Account account);
			//String updateField, String userInput);
	//
	// String firstNameSearch(String firstName);
	//
	// String lastNameSearch(String lastName);
}
