package com.javaex.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.BoardVo;
import com.javaex.vo.GuestBookVo;
import com.javaex.vo.UserVo;

public class BoardDao {

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
	}// getConnection()

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
	}// close()

	public List<BoardVo> boardList() {
		this.getConnection();

		List<BoardVo> boardList = new ArrayList<BoardVo>();

		try {
			String query = "";
			query += " select b.no, b.title, b.content, b.hit, b.reg_date, b.user_no, u.name, u.id ";
			query += " from board b, users u where b.user_no = u.no ";

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			System.out.println(query);
			while (rs.next()) {
				int no = rs.getInt("b.no");
				int hit = rs.getInt("b.hit");
				int userNo = rs.getInt("b.user_no");
				String title = rs.getString("b.title");
				String content = rs.getString("b.content");
				String date = rs.getString("b.reg_date");
				String name = rs.getString("u.name");
				String id = rs.getString("u.id");

				BoardVo boardVo = new BoardVo(no, hit, title, content, date, userNo, name, id);
				boardList.add(boardVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();
		return boardList;
	}// boardList()

	public void boardInsert(BoardVo vo) {
		this.getConnection();

		try {
			System.out.println("추가");
			String query = "";
			query += " insert into board values(null, ?, ?, 0, now(), ?) ";

			System.out.println("id= " + vo.getId());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getUserNo());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();
	}// boardInsert()

	public void boardDelete(int no) {
		this.getConnection();

		try {
			System.out.println("삭제");
			String query = "";
			query += " delete from board where no = ? ";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();
	}// boardDelete

	public void boardRead(BoardVo vo) {
		this.getConnection();
		List<BoardVo> boardList = new ArrayList<BoardVo>();

		try {
			String query = "";
			query += " select u.name, b.title, b.content, b.hit, b.reg_date  ";
			query += " from users u, board b where b.title = ? and u.no = b.user_no ";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int hit = rs.getInt("b.hit");
				String name = rs.getString("u.name");
				String title = rs.getString("b.title");
				String content = rs.getString("b.content");
				String date = rs.getString("b.reg_date");

				BoardVo boardVo = new BoardVo(hit, title, content, date, name);
				boardList.add(boardVo);
				
				System.out.println(boardVo);

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();
	}// boardInsert()

}
