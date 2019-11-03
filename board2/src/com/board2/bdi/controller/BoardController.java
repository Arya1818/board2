package com.board2.bdi.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board2.bdi.service.impl.BoardServiceImpl;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String biTitle = request.getParameter("biTitle");
		String biContent = request.getParameter("biContent");
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String path = "";
		BoardServiceImpl bs = new BoardServiceImpl();
		System.out.println(uri);
		if("insert".equals(cmd)) {
			Map<String,String> bMap = bs.doInsert(biTitle, biContent);
			
			
		}
		
		
		doGet(request, response);
		doPost(request, response);
	}

}
