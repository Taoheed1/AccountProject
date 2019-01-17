package com.qa.persistance.repository;

public interface AccountRepository {

	String createAccount(String firstName, String lastName, int accountNumber);

	String getAllAccounts();

	String deleteAccount(int accountNumber);

	String updateAccount(int accountNumber, String updateField, String userInput);
}
