package com.javaex.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.GuestBookVo;

public class GuestBookDao {
	
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
	
	public void userInsert(GuestBookVo vo) {
		getConnection();
		
		List<GuestBookVo> guestList = new ArrayList<GuestBookVo>();
		
		try {
			String query = "";
			query += " insert into guestbook ";
			query += " values(null, ?, ?, ?, now()) ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getContent());
			
			GuestBookVo guestVo = new GuestBookVo(vo.getName(), vo.getPw(), vo.getContent());
			guestList.add(guestVo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		close();
	}//userInsert()
	
	public void userDelete(String pw, int no) {
		getConnection();
		try {
			System.out.println("삭제삭제");
			String query = "";
			query += " delete from guestbook where pw = ? and book_id = ? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pw);
			pstmt.setInt(2, no);
			
			int count = pstmt.executeUpdate();
			System.out.println(count+"건 성공");
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		close();
	}//userInsert()
	
	public List<GuestBookVo> guestSelect() {
		getConnection();
		List<GuestBookVo> guestList = new ArrayList<GuestBookVo>();
		
		try {
			String query = "";
			query += " select book_id, name, pw, content, date from guestbook ";
			
			pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bookId = rs.getInt("book_id");
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String content = rs.getString("content");
				String date = rs.getString("date");
				
				GuestBookVo guestVo = new GuestBookVo(bookId, name, pw, content, date);
				guestList.add(guestVo);
				
			}
			
			for (int i = 0; i < guestList.size(); i++) {
				System.out.println(guestList.get(i).toString());
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		close();
		return guestList;
	}
	
	
}
