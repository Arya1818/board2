package com.board2.bdi.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public Map<String, String> insertBoard(Map<String, String> bMap) {
		try {
			Class.forName(DRIVER_NAME);
			
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(URL, ID, PWD);

			String sql = "insert into board_info(bi_num,bi_title,bi_content,ui_num,credat,cretim,modat,modtim";
			sql += "values(seq_ui_num.nextval,?,?,?,to_char(sysdate,'yyyymmdd'),to_char(sysdate,'hh24miss'),to_char(sysdate,'yyyymmdd'),to_char(sysdate,'hh24miss')";

			ps.setString(1, bMap.get("biTitle"));
			ps.setString(2, bMap.get("biContent"));
			ps.setString(3, "uiNum");

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			System.out.println(rs);

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				
				if (rs != null) {
					con.close();
				}
				if (ps != null) {
					con.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}
}
