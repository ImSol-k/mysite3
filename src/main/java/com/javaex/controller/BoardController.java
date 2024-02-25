package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.Dao.BoardDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("list".equals(action)) {
			System.out.println("list");

			BoardDao boardDao = new BoardDao();
			List<BoardVo> boardList = boardDao.boardList();

			
			request.setAttribute("boardList", boardList);
			WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
			
			System.out.println("완료");
		} else if ("writeForm".equals(action)) {
			System.out.println("writeForm");
			
			WebUtil.forward(request, response, "/WEB-INF/views/board/writeForm.jsp");
			
		} else if ("write".equals(action)) {
			System.out.println("write");
			
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			HttpSession session = request.getSession();
            UserVo authUser = (UserVo)session.getAttribute("authUser");
            int no = authUser.getNo();
            
			BoardVo boardVo = new BoardVo(title, content, no);
			BoardDao boardDao = new BoardDao();
			boardDao.boardInsert(boardVo);
			
			WebUtil.redirect(request, response, "/mysite3/board?action=list");
		} else if ("delete".equals(action)) {
			System.out.println("delete");
			
			HttpSession session = request.getSession();
            UserVo userVo = (UserVo)session.getAttribute("userVo");
            int no = userVo.getNo();
			
			BoardDao boardDao = new BoardDao();
			boardDao.boardDelete(no);
			
			WebUtil.redirect(request, response, "/mysite3/board?action=list");
		} else if ("readForm".equals(action)) {
			System.out.println("read");
			
			String title = request.getParameter("title");
			
			System.out.println(title);
			
			BoardVo boardVo = new BoardVo(title);
			BoardDao boardDao = new BoardDao();
			boardDao.boardRead(boardVo);
			WebUtil.forward(request, response, "/WEB-INF/views/board/read.jsp");
		} 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
