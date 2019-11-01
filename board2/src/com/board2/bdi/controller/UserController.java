package com.board2.bdi.controller;

import java.io.IOException;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uiId = request.getParameter("uiId");
		String uiPwd = request.getParameter("uiPwd");
		String uiName = request.getParameter("uiName");
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String path = "/views/msg";
		UserServiceImpl us = new UserServiceImpl();
		
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

		} else if ("signup".equals(cmd)) {
			Map<String,Object> rMap = us.doSignup(uiName, uiId, uiPwd);
			String url = "";
			String msg = "";
			
			if(rMap!=null) {
				url = (String)rMap.get("url");
				msg = (String)rMap.get("msg");
			}else {
				url = "/views/user/signup";
				msg = "회원가입 오류.";
			}

		} else if ("logout".equals(cmd)) {

		} else if ("update".equals(cmd)) {

		} else if ("delete".equals(cmd)) {

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
