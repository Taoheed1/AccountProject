package com.qa.persistance.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional
public class AccountMapRepository implements AccountRepository {

	HashMap<Integer, Account> accounts = new HashMap<>();
	private int counter = 1;
	@Inject
	private JSONUtil util;

	public String getAllAccounts() {
		return util.getJSONForObject(accounts);
	}

	public String createAccount(String firstName, String lastName, int accountNumber) {
		accounts.put(counter, new Account(firstName, lastName, counter));
		counter++;
		return null;
	}

	public String deleteAccount(int counter) {
		accounts.remove(counter);

		return null;
	}

	@Override
	public String updateAccount(int accountNumber, String updateField, String userInput) {
		// TODO Auto-generated method stub

		switch (userInput) {
		case "firstName":
			accounts.get(accountNumber).setFirstName(userInput);
			break;
		case "lastName":
			accounts.get(accountNumber).setLastName(userInput);
			break;
		}
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
