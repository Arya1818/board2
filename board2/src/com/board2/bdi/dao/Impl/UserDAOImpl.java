package com.board2.bdi.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.board2.bdi.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "bdi";
	private static final String PWD = "12345678";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public Map<String,String> selectUser(Map<String,String> user){
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "select * from user_info where ui_id=? and ui_pwd=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("uiId"));
			ps.setString(2, user.get("uiPwd"));
			rs = ps.executeQuery();
			
			if(rs.next()) { //return true or false, // 아이디, 비번이 올바르게 동작했을 때 true
				user.put("uiNum",rs.getString("ui_num"));
				user.put("uiName",rs.getString("ui_name"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					con.close();
				}
				if(ps!=null) {
					con.close();
				} 
				if(con!=null) {
					con.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		}
		return null;
	}
	
	public Map<String,Object> doSignup(String uiName, String uiId, String uiPwd){
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "insert into user_info(ui_num, ui_name, ui_id, ui_pwd, credat, cretim, modat, modtim)";
			sql += "values(seq_ui_num.nextval,?,?,?,to_char(sysdate,'yyyymmdd'),to_char(sysdate,'hh24miss'),to_char(sysdate,'yyyymmdd'),to_char(sysdate,'hh24miss'))"; 
			ps = con.prepareStatement(sql);
			ps.setString(1, uiName);
			ps.setString(2, uiId);
			ps.setString(3, uiPwd);
			
			if(ps.executeUpdate()==1) {
				Map<String,Object> rMap = new HashMap<String,Object>();
				rMap.put("msg", uiName + "님 회원가입이 성공하였습니다");
				rMap.put("url","/views/user/login");
				return rMap;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					con.close();
				}
				if(ps!=null) {
					con.close();
				} 
				if(con!=null) {
					con.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		UserDAO udao = new UserDAOImpl();
//		Map<String,String> user = new HashMap<>();
//		user.put("uiId", "amore18");
//		user.put("uiPwd", "123456");
//		user = udao.selectUser(user);
//		System.out.println(user);
	}
	
