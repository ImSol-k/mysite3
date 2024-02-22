package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.Dao.GuestBookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestBookVo;

@WebServlet("/guestbook")
public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("GuestBookStart");

		String action = request.getParameter("action");
		if ("gbForm".equals(action)) {
			System.out.println("gbForm");
			
			GuestBookDao guestDao = new GuestBookDao();

			List<GuestBookVo> guestList = guestDao.guestSelect();;

			request.setAttribute("guestList", guestList);

			WebUtil.forward(request, response, "/WEB-INF/views/guest/addList.jsp");
			
		} else if ("add".equals(action)) {
			System.out.println("add");

			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			String content = request.getParameter("content");
			request.setAttribute("name", name);
			request.setAttribute("pass", pass);
			request.setAttribute("content", content);

			System.out.println(name);
			System.out.println(pass);
			System.out.println(content);

			GuestBookVo guestVo = new GuestBookVo(name, pass, content);
			GuestBookDao guestDao = new GuestBookDao();
			guestDao.userInsert(guestVo);
			
			response.sendRedirect("/mysite3/guestbook?action=gbForm");

		} else if ("deleteForm".equals(action)) {
			System.out.println("deleteForm");
			
			String pass = request.getParameter("pass");
			int no = Integer.parseInt(request.getParameter("no"));
			
			request.setAttribute("pass", pass);
			request.setAttribute("no", no);

			WebUtil.forward(request, response, "/WEB-INF/views/guest/deleteForm.jsp");
		} else if ("delete".equals(action)) {
			System.out.println("delete");
			
			String pass = request.getParameter("pass");
			int no = Integer.parseInt(request.getParameter("no"));
						
			System.out.println(pass + no);
			
			GuestBookDao guestDao = new GuestBookDao();
			guestDao.userDelete(pass, no);
			
			response.sendRedirect("/mysite3/guestbook?action=gbForm");
		} else if ("main".equals(action)) {
			System.out.println("main");

			WebUtil.forward(request, response, "/WEB-INF/views/main/index.jsp");
		} else if ("guestlist".equals(action)) {
			
			GuestBookDao guestDao = new GuestBookDao();
			guestDao.guestSelect();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
