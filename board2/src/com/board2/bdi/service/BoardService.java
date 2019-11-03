package com.board2.bdi.service;

import java.util.Map;

public interface BoardService {
	public Map<String,String> doInsert(String title, String content);
}
