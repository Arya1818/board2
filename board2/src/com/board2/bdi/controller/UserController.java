package com.board2.bdi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board2.bdi.service.UserService;
import com.board2.bdi.service.impl.UserServiceImpl;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl(); // 메모리생성되고 계속 쓰려고 위로 빼줌!

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String path="/views/user/list";
		
		Map<String,String> user = new HashMap<String,String>();
		//리스트목록 & 검색
		if("list".equals(cmd)) {
			if(request.getParameter("uiId")!=null
					&&request.getParameter("uiId").trim().equals("")) {
				user.put("uiId", request.getParameter("uiId"));
			}
			else if(request.getParameter("uiNum")!=null
					&&request.getParameter("uiNum").trim().equals("")) {
				user.put("uiNum", request.getParameter("uiNum"));
			}
			else if(request.getParameter("uiName")!=null
					&&request.getParameter("uiName").trim().equals("")) {
				user.put("uiName", request.getParameter("uiName"));
			}
			
			request.setAttribute("list", us.userList(user)); //아깐null이였는ㅇ데 왜 지금은 user?
			
		//로그아웃
		}else if("logout".equals(cmd)){
			HttpSession hs = request.getSession(); 
			hs.invalidate(); 
			path="/";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String uiId = request.getParameter("uiId");
		String uiPwd = request.getParameter("uiPwd");
		String uiName = request.getParameter("uiName");
		String uri = request.getRequestURI(); // 요청받은 uri는 /users/login
		String cmd = uri.substring(7); // cmd는 login 
		String path = "/views/msg";
		UserServiceImpl us = new UserServiceImpl(); 
		
		//로그인
		if ("login".equals(cmd)) {
			Map <String,String> user = us.doLogin(uiId, uiPwd);
			if(user!=null) { //null이 아닐때 session에다 user을 넣어준다.
				HttpSession hs = request.getSession(); //스쿠프
				hs.setAttribute("user", user); //로그인됐을때 다시 받아와야하니 map 
				request.setAttribute("msg", "로그인성공");
				request.setAttribute("url", "/views/index");

			} else {
				request.setAttribute("msg", "로그인실패");
				request.setAttribute("url", "/views/user/login");
			}
		//회원가입
		} else if ("signup".equals(cmd)) {
			Map<String,String> rMap = us.doSignup(uiName, uiId, uiPwd);
			if(rMap!=null) {
				request.setAttribute("msg", "회원가입완료");
				request.setAttribute("url", "/views/index");
			}else {
				request.setAttribute("msg", "회원가입실패");
				request.setAttribute("url", "/views/user/signup");
			}
			
		} else if ("update".equals(cmd)) {

		} else if ("delete".equals(cmd)) {

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
