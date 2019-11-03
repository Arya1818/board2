package com.board2.bdi.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.board2.bdi.dao.BoardDAO;
import com.board2.bdi.dao.Impl.BoardDAOImpl;
import com.board2.bdi.service.BoardService;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO bdao = new BoardDAOImpl();
	
	public Map<String,String> doInsert(String biTitle, String biContent){
		Map<String,String> board = new HashMap<>();
		board.put("biTitle", biTitle);
		board.put("biContent",biContent);
		return bdao.insertBoard(board);
	
	}
}
