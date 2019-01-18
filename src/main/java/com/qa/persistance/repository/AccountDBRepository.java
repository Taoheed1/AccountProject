package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a from Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(Account account) {
		Account anAccount = util.getObjectForJSON(createAccount(account), Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(int accountNumber) {
		
		Account accountInDB = findAccount(accountNumber);
		if (accountInDB != null) {
			manager.remove(findAccount(accountNumber));

			return "{\"message\": \"account has been sucessfully deleted\"}";
		} else {
			return "{\"message\": \"account does not exist\"}";
		}
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(int accountNumber, Account account) {
		//, String updateField, String userInput) {
	

		Account accountInDB = findAccount(accountNumber);
//		if (accountInDB != null) {
//			switch (updateField) {
//			case "firstName":
//				accountInDB.setFirstName(userInput);
//				break;
//			case "lastName":
//				accountInDB.setLastName(userInput);
//				break;
//			case "accountNumber":
//				accountInDB.setAccountNumber((int) accountNumber);
//				break;
//			}
//			manager.persist(accountInDB);
//		}
		manager.persist(accountInDB);
		manager.remove(accountInDB);
		
	return "{\"message\": \"account has been sucessfully updated\"}";
	}

	public Account findAccount(int accountNumber) {
		return manager.find(Account.class, accountNumber);
	}

	public void setManager() {
		this.manager = manager;
	}

	public void seUtil() {
		this.util = util;
	}

}
