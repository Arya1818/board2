package com.board2.bdi.service;

import java.util.Map;

public interface UserService {
	public Map<String,String> doLogin(String id, String pwd);
}
