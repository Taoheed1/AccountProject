package com.qa.business.service;

public interface AccountService {

	String createAccount(String firstName, String lastName, int accountNumber);

	String getAllAccounts();

	String deleteAccount(int accountNumber);

	String updateAccount(int accountNumber);
//
//	String firstNameSearch(String firstName);
//
//	String lastNameSearch(String lastName);
}
