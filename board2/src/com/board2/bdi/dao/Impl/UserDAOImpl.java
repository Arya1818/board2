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

import com.board2.bdi.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "bdi";
	private static final String PWD = "12345678";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//유저리스트
	public List<Map<String,String>> selectUserList(Map<String,String> user){
		List<Map<String,String>> userList = new ArrayList<>();
		try {
			con = DriverManager.getConnection(URL, ID, PWD);
			String sql = "select * from user_info where 1=1 ";
			if(user.get("uiId")!=null) {
				sql += " and ui_id=?";
			}
			if(user.get("uiNum")!=null) {
				sql += " and ui_num=?";
			}
			if(user.get("uiName")!=null) {
				sql += " and ui_name=?";
			}
			
			ps = con.prepareStatement(sql);
			
			//한개만 null 아닐경우
			if(user.get("uiId")!=null&&user.get("uiNum")==null&&user.get("uiName")==null) {
				ps.setString(1, user.get("uiId"));
			}
			else if(user.get("uiId")==null&&user.get("uiNum")!=null&&user.get("uiName")==null) {
				ps.setString(1, user.get("uiNum"));
			}
			else if(user.get("uiId")==null&&user.get("uiNum")==null&&user.get("uiName")!=null) {
				ps.setString(1, user.get("uiName"));
			}
			//두개가 null 아닐경우
			else if(user.get("uiId")!=null&&user.get("uiNum")!=null&&user.get("uiName")==null) {
				ps.setString(1, user.get("uiId"));
				ps.setString(2, user.get("uiNum"));
			}
			else if(user.get("uiId")==null&&user.get("uiNum")!=null&&user.get("uiName")!=null) {
				ps.setString(1, user.get("uiNum"));
				ps.setString(2, user.get("uiName"));
			}
			else if(user.get("uiId")!=null&&user.get("uiNum")==null&&user.get("uiName")!=null) {
				ps.setString(1, user.get("uiId"));
				ps.setString(2, user.get("uiName"));
			}
			//세개가 null 아닐경우
			else if(user.get("uiId")!=null&&user.get("uiNum")!=null&&user.get("uiName")!=null){
				ps.setString(1, user.get("uiId"));
				ps.setString(2, user.get("uiNum"));
				ps.setString(3, user.get("uiName"));
			}
			
		
			rs = ps.executeQuery();
			while(rs.next()) { 
				Map<String,String> u = new HashMap<>();
				u.put("uiNum", rs.getString("ui_num"));
				u.put("uiId", rs.getString("ui_id"));
				u.put("uiName", rs.getString("ui_name"));
//				u.put("cretim", rs.getString("cretim"));
//				u.put("moddat", rs.getString("moddat"));
//				u.put("modtim", rs.getString("modtim"));
//				u.put("active", rs.getString("active"));
//				u.put("credat", rs.getString("credat"));
				userList.add(u);
				
			}
			return userList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		return null;
		}
		
	//로그인
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
			ps.setString(1, user.get("uiId")); //amore18
			ps.setString(2, user.get("uiPwd"));//123456
			rs = ps.executeQuery();
			
			if(rs.next()) { //return true or false, // 아이디, 비번이 올바르게 동작했을 때 true
				user.put("uiNum",rs.getString("ui_num")); 					//true 이니 uiNum과 uiName을 가져옴?왜가져오지? board할때 쓰려고..
				user.put("uiName",rs.getString("ui_name"));
				System.out.println(user);
				return user;
			}
		} catch (SQLException e) {
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
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		}
		return null;
	}
	
	//회원가입
	public Map<String,String> doSignup(Map<String,String> rMap){
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
			ps.setString(1, rMap.get("uiName"));
			ps.setString(2, rMap.get("uiId"));
			ps.setString(3, rMap.get("uiPwd"));
			
			if(ps.executeUpdate()==1) {
				System.out.println(rMap);
				return rMap;
			}	
		} catch (SQLException e) {
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
	
