package com.board2.bdi.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.board2.bdi.dao.UserDAO;
import com.board2.bdi.dao.Impl.UserDAOImpl;
import com.board2.bdi.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDAO udao = new UserDAOImpl(); //메모리만들고 database execute하려면 있어야하니까 위에 선언
	
	@Override
	public Map<String,String> doLogin(String uiId, String uiPwd) {
		Map<String,String> user = new HashMap<>();
		user.put("uiId", uiId);
		user.put("uiPwd", uiPwd);
		return udao.selectUser(user); //있을 경우 map을 리턴, 없으면 null을 리턴
		
	
//		return user!=null; //null이 아닐땐 true반환
		
	
	}
	public Map<String,Object> doSignup(String uiName, String uiId, String uiPwd){
		 Map<String,Object> rMap = new HashMap<String,Object>();
		 rMap.put("msg", uiName + "님 회원가입 성공!");
		 rMap.put("url","/views/user/signup");
		 
		 return rMap;

	}
}

