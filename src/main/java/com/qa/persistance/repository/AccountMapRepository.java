package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class AccountMapRepository implements AccountRepository {

	HashMap<Integer, Account> accounts = new HashMap<>();
	private int counter = 1;

	@Inject
	private JSONUtil util;

	public String getAllAccounts() {
		return util.getJSONForObject(accounts);
	}

	@Transactional(REQUIRED)
	public String createAccount(Account account) {
		accounts.put(counter, new Account());
		counter++;
		if (accounts.size() == counter) {
			return "account successfully created";
		} else {
			return "account creation failed";
		}
	}

	@Transactional(REQUIRED)
	public String deleteAccount(int accountNumber) {
		if (accounts.get(accountNumber) != null) {
			accounts.remove(accountNumber);
			return "account successfully deleted";
		} else {
			return "account does not exist";
		}
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(int accountNumber,Account account) {
		//String updateField, String userInput) {
	
		// TODO Auto-generated method stub

//		switch (userInput) {
//		case "firstName":
//			accounts.get(accountNumber).setFirstName(userInput);
//			break;
//		case "lastName":
//			accounts.get(accountNumber).setLastName(userInput);
//			break;
//		}
		accounts.get(accountNumber).setFirstName(account.getFirstName());
		accounts.get(accountNumber).setLastName(account.getLastName());


		return "Account has been successfully updated";
	}

	public int firstNameSearch(String searchFirstName) {

		List<Account> accountList = accounts.values().stream().filter(a -> a.getFirstName() == searchFirstName)
				.collect(Collectors.toList());

		return accountList.size();
	}

	public int lastNameSearch(String searchLastName) {
		int occurences = 0;
		Collection<Account> accountCollection = accounts.values();

		for (Account users : accountCollection) {
			if (users.getLastName() == searchLastName) {
				occurences++;
			}
		}
		return occurences;
	}

}
