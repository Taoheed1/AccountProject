package com.qa.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.persistance.repository.Service;
import com.qa.persistence.domain.Account;

public class PersistanceTests {

	Service service = new Service();
	Account account = new Account("Michael", "Jordan", 1);

	@Test
	public void addAccountTest() {
		assertTrue("Test failed", service.addAccount("Jeff", "Jeffers"));
	}
	
	@Test
	public void getFirstNameTest() {
		service.addAccount("Jeff", "Jeffers");
		assertEquals("Jeff", service.getAccount(1).getFirstName());
	}
	
	@Test
	public void getLastNameTest() {
		service.addAccount("Jeff", "Jeffers");
		assertEquals("Jeffers", service.getAccount(1).getLastName());
	}
	
	@Test
	public void addAccountNumberTest() {
		service.addAccount("Jeff", "Jeffers");
		assertEquals(1, service.getAccount(1).getAccountNumber());
	}

	@Test
	public void deleteAccountTest() {
		service.addAccount("Tom", "Jerry");
		assertEquals(true, service.deleteAccount(1));
	}

	@Test
	public void getAccountTest() {
		service.addAccount("Chris", "Bowers");
		assertEquals(1, service.getAccount(1).getAccountNumber());
	}

	
	


}
