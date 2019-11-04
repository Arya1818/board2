package test.impl;

import java.util.Map;

import test.BoardDAO;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public int insertBoard(Map<String,String> board) {
		
		return 0;
	}
	public static void main(String[] args) {
		BoardDAO bdao = new BoardDAOImpl(); //rule
		int result = bdao.insertBoard(null);
		if(result==1) {
			System.out.println("저장 잘됐군");
		}else {
			System.out.println("저장안됐다.");
		}
	}
}
