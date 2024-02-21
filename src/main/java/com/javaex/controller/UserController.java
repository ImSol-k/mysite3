package com.javaex.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if ("joinFrom".equals(action)) {
			
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
			//System.out.println(userVo);
			WebUtil.forward(request, response, "/WEB-INF/views/user/joinOk.jsp");
			 
		} else if("loginForm".equals(action)) {
			System.out.println("loginForm");
			
			WebUtil.forward(request, response, "/WEB-INF/views/user/loginForm.jsp");
		} else if("login".equals(action)) {
			System.out.println("login");
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			UserVo userVo = new UserVo(id, pw);
			UserDao userDao = new UserDao();
			userDao.userLogin(userVo);
			
		}
		else {
			System.out.println("action값을 다시 입력해주세요");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
