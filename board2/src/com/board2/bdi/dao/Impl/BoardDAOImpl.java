package com.board2.bdi.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board2.bdi.dao.BoardDAO;

public class BoardDAOImpl implements BoardDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "bdi";
	private static final String PWD = "12345678";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	int result;

//	public static void main(String[] args) { //다오,서비스 문제없는거 확인할때
//		BoardDAO bdao = new BoardDAOImpl();
//		Map<String,String> board = new HashMap<>();
//		board.put("biTitle","테스트")
//		board.put("biContent","test data");
//		board.put("uiNum","8");
//		bdao.insertBoard(board);
//	}

	public int insertBoard(Map<String, String> board) {
		try {
			Class.forName(DRIVER_NAME); // 클래스 드라이버 있어야함

		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(URL, ID, PWD); // 전화기 / exception을 강요!

			String sql = "insert into board_info(bi_num,bi_title,bi_content,ui_num,credat,cretim,modat,modtim)";
			sql += " values(seq_bi_num.nextval,?,?,?,to_char(sysdate,'yyyymmdd'),to_char(sysdate,'hh24miss'),to_char(sysdate,'yyyymmdd'),to_char(sysdate,'hh24miss'))";
			ps = con.prepareStatement(sql); // sql문을 statement에 준비
			ps.setString(1, board.get("biTitle"));
			ps.setString(2, board.get("biContent"));
			ps.setString(3, board.get("uiNum"));

			return ps.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {

				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return 0;
	}

	@Override
	public List<Map<String, String>> getBoardList(Map<String, String> board) {

		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(URL, ID, PWD);

			String sql = "select * from board_info";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Map<String, String>> list = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> b = new HashMap<>();
				b.put("biNum", rs.getString("bi_num"));
				b.put("biTitle", rs.getString("bi_title"));
				// b.put("biContent", rs.getString("bi_content"));
				b.put("uiNum", rs.getString("ui_num"));
				// b.put("uiName", rs.getString("ui_name"));
				// b.put("uiId", rs.getString("ui_Id"));
				b.put("credat", rs.getString("credat"));
				b.put("cretim", rs.getString("cretim"));
				list.add(b);
			}

			return list;

		} catch (NullPointerException e) {
			System.out.println("a");
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Map<String, String> selectBoard(Map<String, String> board) {

		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(URL, ID, PWD);

			String sql = "select * from board_info bi, user_info ui ";
			sql += " where bi.ui_num=ui.ui_num";
			sql += " and bi_num=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biNum"));
			rs = ps.executeQuery();

			while (rs.next()) {
				Map<String, String> b = new HashMap<>();
				b.put("biNum", rs.getString("bi_num"));
				b.put("biTitle", rs.getString("bi_title"));
				b.put("biContent", rs.getString("bi_content"));
				b.put("uiNum", rs.getString("ui_num"));
				b.put("uiName", rs.getString("ui_name"));
				b.put("uiId", rs.getString("ui_Id"));
				b.put("credat", rs.getString("credat"));
				b.put("cretim", rs.getString("cretim"));
				return b;
			}

		} catch (NullPointerException e) {
			System.out.println("a");
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;

	}
	
	public int updateBoard(Map<String, String> board) {
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "update board_info"
					+ " set bi_title=?"
					+ ", bi_content=?"
					+ " where bi_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biTitle"));
			ps.setString(2, board.get("biContent"));
			ps.setString(3, board.get("biNum"));
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteBoard(Map<String, String> board) {
	
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "delete from board_info where bi_num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.get("biNum"));
			return ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return 0;
	}

}
