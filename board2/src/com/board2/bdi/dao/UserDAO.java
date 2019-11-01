package com.board2.bdi.dao;

import java.util.Map;

public interface UserDAO {
	public Map<String,String> selectUser(Map<String,String> user);
}
