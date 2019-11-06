package com.board2.bdi.dao;

import java.util.List;
import java.util.Map;

public interface UserDAO {
	public Map<String,String> selectUser(Map<String,String> user);

	public Map<String, String> doSignup(Map<String, String> rMap);

	public List<Map<String, String>> selectUserList(Map<String, String> user);



}
