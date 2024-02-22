package com.javaex.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.javaex.vo.UserVo;

public class UserDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/web_db";
			conn = DriverManager.getConnection(url, "web", "web");
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}//getConnection()
	
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}//close()

	public void userInsert(UserVo vo) {
		getConnection();
		try {
			String query = "";
			query += " insert into users ";
			query += " values(null, ?, ?, ?, ?) ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getGender());
			
			System.out.println(query);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		close();
	}//userInsert()
	
	public UserVo userLogin(UserVo vo) {
		
		getConnection();
		UserVo authUser = null;
		try {
			
			String query = "";
			query += " select no, name from users ";
			query += " where id = ? and pass = ? ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String name  = rs.getString("name");
				authUser = new UserVo();
				authUser.setNo(no);
				authUser.setName(name);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		close();
		
		return authUser;
		
		
	}//userLogin
	
	public UserVo userUpdate(int no, UserVo vo) {
		getConnection();
		try {
			String query = "";
			query += " update users  ";
			query += " set pass = ?, name = ?, gender = ? ";
			query += " where no = ? ";
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getGender());
			pstmt.setInt(4, no);
			
			System.out.println(vo);
			pstmt.executeUpdate();
						
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		close();
		return vo;
	}//userUpdate()

}
