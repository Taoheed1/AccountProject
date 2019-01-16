package com.qa.persistance.repository;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qa.persistence.domain.Account;

public class Service {

	HashMap<Integer, Account> accounts = new HashMap<>();
	private int counter = 1;
	Gson gson = new GsonBuilder().create();

	public boolean addAccount(String firstName, String lastName) {
		accounts.put(counter, new Account(firstName, lastName, counter));
		counter++;
		return true;
	}
	
	public boolean deleteAccount(int counter) {
		accounts.remove(counter);
		return true;
	}

	public Account getAccount(Integer accountNumber) {
		return accounts.get(accountNumber);
	}
	

}
