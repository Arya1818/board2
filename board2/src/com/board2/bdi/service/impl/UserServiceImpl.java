package com.board2.bdi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board2.bdi.dao.UserDAO;
import com.board2.bdi.dao.Impl.UserDAOImpl;
import com.board2.bdi.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDAO udao = new UserDAOImpl(); //메모리만들고 database execute하려면 있어야하니까 위에 선언
	
	@Override //유저리스트
	public List<Map<String,String>> userList(Map<String,String> user){
		
		return udao.selectUserList(user);
	}
	
	
	@Override //로그인
	public Map<String,String> doLogin(String uiId, String uiPwd) {
		Map<String,String> user = new HashMap<>(); //user는 의미부여x 변수명임.
		user.put("uiId", uiId); //UserController에서 보낸걸 맵 안에저장
		user.put("uiPwd", uiPwd);
		return udao.selectUser(user); //있을 경우 map을 리턴, 없으면 null을 리턴
		
	
//		return user!=null; //null이 아닐땐 true반환
		
	}
	@Override //회원가입
	public Map<String,String> doSignup(String uiName, String uiId, String uiPwd){
		 Map<String,String> rMap = new HashMap<>();
		 
		 rMap.put("uiName",uiName);
		 rMap.put("uiId",uiId);
		 rMap.put("uiPwd",uiPwd);
		 return udao.doSignup(rMap);
	}
	
}
