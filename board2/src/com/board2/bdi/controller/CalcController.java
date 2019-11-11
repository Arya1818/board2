package com.board2.bdi.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/CalcController")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getParameter("json");
		Gson g = new Gson();
		Map<String,String> param = g.fromJson(json, Map.class); //{"num1":"5","num2":"5","op":"+"} 에서 맵처럼 key value 해줘.
		
		System.out.println(json);
		
		int num1 = Integer.parseInt(param.get("num1"));
		int num2 = Integer.parseInt(param.get("num2"));
		String op = param.get("op");
		
		int result = 0;
		if("+".equals(op)) {
			result = num1+num2;
		}else if("-".equals(op)){
			result = num1-num2;
		}else if("/".equals(op)){
			result = num1/num2;
		}else if("*".equals(op)){
			result = num1*num2;
		}
		
		//response.getWriter().print((num1 + num2) + ""); //String으로.
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
