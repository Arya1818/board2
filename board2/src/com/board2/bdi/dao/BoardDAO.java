package com.board2.bdi.dao;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	public int insertBoard(Map<String,String> bMap);
	public List<Map<String,String>> getBoardList(Map<String,String> board);
	public Map<String, String> selectBoard(Map<String, String> board);
	public int deleteBoard(Map<String, String> board);
	public int updateBoard(Map<String, String> board);
}
