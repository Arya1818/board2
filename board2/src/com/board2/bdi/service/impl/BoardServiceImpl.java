package com.board2.bdi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board2.bdi.dao.BoardDAO;
import com.board2.bdi.dao.Impl.BoardDAOImpl;
import com.board2.bdi.service.BoardService;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO bdao = new BoardDAOImpl();
	
	public Map<String,String> doInsert(String biTitle, String biContent, String uiNum){ //맵할필요없음
		Map<String,String> board = new HashMap<>();
		board.put("biTitle", biTitle);
		board.put("biContent",biContent);
		board.put("uiNum", uiNum);
		if(bdao.insertBoard(board)==1) {
			board.put("msg", "등록완료");
			board.put("url", "/board/list");
		}else {
			board.put("msg", "잘하자.");
			board.put("url", "/views/board/insert");
		}
		return board;
	}

	@Override
	public List<Map<String, String>> getBoardList(Map<String, String> board) {
		
		return bdao.getBoardList(board);
	}
}
