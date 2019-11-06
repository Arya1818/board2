package com.board2.bdi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board2.bdi.dao.BoardDAO;
import com.board2.bdi.dao.Impl.BoardDAOImpl;
import com.board2.bdi.service.BoardService;

public class BoardServiceImpl implements BoardService {

	private BoardDAO bdao = new BoardDAOImpl();

	public Map<String, String> doInsert(String biTitle, String biContent, String uiNum) { // 맵할필요없음
		Map<String, String> board = new HashMap<>();
		board.put("biTitle", biTitle);
		board.put("biContent", biContent);
		board.put("uiNum", uiNum);
		if (bdao.insertBoard(board) == 1) {
			board.put("msg", "등록완료");
			board.put("url", "/board/list");
<<<<<<< HEAD
		}else {
			board.put("msg", "오류.");
=======
		} else {
			board.put("msg", "잘하자.");
>>>>>>> branch 'master' of https://github.com/Arya1818/board2.git
			board.put("url", "/views/board/insert");
		}
		return board;
	}

	@Override
	public List<Map<String, String>> getBoardList(Map<String, String> board) {

		return bdao.getBoardList(board);
	}

	public Map<String, String> getBoard(Map<String, String> board) {

		return bdao.selectBoard(board);
	}

	public Map<String, String> updateBoard(Map<String, String> board) {
		int result = bdao.updateBoard(board);
		Map<String, String> rMap = new HashMap<>();
		if (result == 1) {
			rMap.put("msg", "게시물 수정 완료.");
			rMap.put("url", "/board/view?biNum=" + board.get("biNum"));
		} else {
			rMap.put("msg", "게시물 수정 실패.");
			rMap.put("url", "/board/view?biNum=" + board.get("biNum"));
		}
		return rMap;
	}

	public Map<String, String> deleteBoard(Map<String, String> board) {
		int result = bdao.deleteBoard(board);
		Map<String, String> rMap = new HashMap<>();
		if (result == 1) {
			rMap.put("msg", "게시물 삭제 완료.");
			rMap.put("url", "/board/list");
		} else {
			rMap.put("msg", "게시물 삭제 실패.");
			rMap.put("url", "/board/view?biNum=" + board.get("biNum"));
		}
		return rMap;

	}
}
