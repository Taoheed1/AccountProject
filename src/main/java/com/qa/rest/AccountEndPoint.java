package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.AccountService;
import com.qa.business.service.AccountServiceImpl;

@Path("/account")
public class AccountEndPoint implements AccountService {

	@Inject
	private AccountServiceImpl service;

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String firstName, String lastName, int accountNumber) {
		// TODO Auto-generated method stub
		return service.createAccount(firstName, lastName, accountNumber);
	}

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		// TODO Auto-generated method stub
		return service.getAllAccounts();
	}

	@Path("/json")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(int accountNumber) {
		// TODO Auto-generated method stub
		return service.deleteAccount(accountNumber);
	}

	@Path("/json")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(int accountNumber) {
		// TODO Auto-generated method stub
		return service.updateAccount(accountNumber);
	}

}
