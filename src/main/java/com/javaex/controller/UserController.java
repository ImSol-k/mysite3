package com.javaex.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.Dao.UserDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.UserVo;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("UserController");

		String action = request.getParameter("action");
		if ("joinForm".equals(action)) {

			System.out.println("joinForm");

			WebUtil.forward(request, response, "/WEB-INF/views/user/joinForm.jsp");

		} else if ("join".equals(action)) {

			System.out.println("join");

			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			String gender = request.getParameter("gender");

			UserVo userVo = new UserVo(id, name, pw, gender);
			UserDao userDao = new UserDao();
			userDao.userInsert(userVo);
			WebUtil.forward(request, response, "/WEB-INF/views/user/joinOk.jsp");

		}
		else if ("loginForm".equals(action)) {
			System.out.println("loginForm");

			WebUtil.forward(request, response, "/WEB-INF/views/user/loginForm.jsp");

		} else if ("login".equals(action)) {
			System.out.println("login");

			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			UserVo userVo = new UserVo(id, pw);
			UserDao userDao = new UserDao();
			UserVo authUser = userDao.userLogin(userVo);

			if (authUser != null) {
				System.out.println("로그인 성공");
				
				HttpSession session = request.getSession();
				session.setAttribute("authUser", authUser);
				session.setAttribute("userVo", userVo);

				WebUtil.redirect(request, response, "/mysite3/main");

			} else {
				System.out.println("실패");
				WebUtil.redirect(request, response, "/mysite3/user?action=loginForm");
			}

		} else if ("logout".equals(action)) {
			System.out.println("logout");

			HttpSession session = request.getSession();
			session.invalidate();
			WebUtil.redirect(request, response, "/mysite3/main");

		}
		else if ("modifyForm".equals(action)) {
			System.out.println("modifyForm");

			WebUtil.forward(request, response, "/WEB-INF/views/user/modifyForm.jsp");
		} else if ("modify".equals(action)) {
			System.out.println("modify");

			int no = Integer.parseInt(request.getParameter("no"));
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			String gender = request.getParameter("gender");

			UserVo userVo = new UserVo(name, pw, gender);
			UserDao userDao = new UserDao();
			userDao.userUpdate(no, userVo);
			
			UserVo modifiedUser = new UserVo(no, id, name, pw, gender);
			HttpSession session = request.getSession();
			session.setAttribute("authUser", modifiedUser);
			
			WebUtil.redirect(request, response, "/mysite3/main");
		} else {
			System.out.println("action값을 다시 입력해주세요");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
