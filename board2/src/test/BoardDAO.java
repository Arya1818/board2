package test;

import java.util.Map;

public interface BoardDAO { //static defualt 제외하고는 어디에도 몸통 못만든다
	public int insertBoard(Map<String,String> board);
	
}
