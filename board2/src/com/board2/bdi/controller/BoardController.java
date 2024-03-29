package com.board2.bdi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board2.bdi.service.impl.BoardServiceImpl;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardServiceImpl bs = new BoardServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String cmd = uri.substring(7);
		String path = "/views/board/list";

		Map<String, String> board = new HashMap<>();
		if ("list".equals(cmd)) {
			List<Map<String, String>> list = bs.getBoardList(board);
			request.setAttribute("list", list);

		} else if ("view".equals(cmd)) {
			path = "/views/board/view";
			board.put("biNum", request.getParameter("biNum"));
			board = bs.getBoard(board);
			request.setAttribute("board", board);

		} else if ("update".equals(cmd)) {
			path = "/views/board/update";
			board.put("biNum", request.getParameter("biNum"));
			board = bs.getBoard(board);
			request.setAttribute("board", board);

		}else if("delete".equals(cmd)) {
			path="/views/msg";
			board.put("biNum", request.getParameter("biNum"));
			Map<String,String> rMap = bs.deleteBoard(board);
			request.setAttribute("msg", rMap.get("msg"));
			request.setAttribute("url", rMap.get("url"));

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession hs = request.getSession();
		Map<String, String> user = (Map<String, String>) hs.getAttribute("user");

		String biTitle = request.getParameter("biTitle");
		String biContent = request.getParameter("biContent");
		String uiNum = user.get("uiNum").toString();
		String uri = request.getRequestURI();
		String cmd = uri.substring(7); // insert
		String path = "/views/msg";

		if ("insert".equals(cmd)) {
			Map<String, String> board = bs.doInsert(biTitle, biContent, uiNum);
			if (board != null) {
				request.setAttribute("msg", board.get("msg"));
				request.setAttribute("url", board.get("url"));

			}
		}else if("update".equals(cmd)) {
			Map<String, String> board = new HashMap<>();
			board.put("biTitle", request.getParameter("bi_title"));
			board.put("biContent", request.getParameter("bi_content"));
			board.put("biNum", request.getParameter("bi_num"));
			Map<String,String> rMap = bs.updateBoard(board);
			request.setAttribute("msg", rMap.get("msg"));
			request.setAttribute("url", rMap.get("url"));
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}
}
