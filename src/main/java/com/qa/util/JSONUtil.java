package com.qa.util;

import java.util.HashMap;

import com.google.gson.Gson;
import com.qa.persistence.domain.Account;

public class JSONUtil {


	private Gson gson;

//	public JSONUtil() {
//		this.gson = new Gson();
//	}

	public String getJSONHashMap(HashMap<Integer, Account> accounts) {
		return gson.toJson(accounts);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}
}
