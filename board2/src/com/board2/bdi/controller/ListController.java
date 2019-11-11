package com.board2.bdi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Listcontroller")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> strList = new ArrayList<>();
		strList.add("1");
		strList.add("배고파");
		strList.add("밥");
		strList.add("줘");
		strList.add("런치~~");
		response.setContentType("text/html;charset=utf-8");
		String html = "";
		for(String str:strList) {
			html += str + "<br>"; 
		}
		response.getWriter().print(html); 
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
