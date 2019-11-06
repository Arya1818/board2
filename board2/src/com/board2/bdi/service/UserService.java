package com.board2.bdi.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	public Map<String,String> doLogin(String id, String pwd);

	public List<Map<String,String>> userList(Map<String,String> user);

	Map<String, String> doSignup(String uiName, String uiId, String uiPwd);

	
}
