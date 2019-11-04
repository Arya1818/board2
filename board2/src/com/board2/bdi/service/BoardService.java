package com.board2.bdi.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	public Map<String,String> doInsert(String biTitle, String biContent, String uiNum);
	public List<Map<String,String>> getBoardList(Map<String,String> board);
}
