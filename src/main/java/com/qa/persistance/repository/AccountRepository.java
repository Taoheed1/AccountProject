package com.qa.persistance.repository;

import com.qa.persistence.domain.Account;

public interface AccountRepository {

	String createAccount(Account account);

	String getAllAccounts();

	String deleteAccount(int accountNumber);

	String updateAccount(int accountNumber, Account account);
	//, String updateField, String userInput);
}
