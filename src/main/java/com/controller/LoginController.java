package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.loginService;

public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	loginService loginservice = new loginService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 测试
		String name = req.getParameter("uname");
		String pwd = req.getParameter("upwd");

		boolean flag = loginservice.login(name, pwd);
		// resp.sendRedirect("testFile.jsp");
		if(!flag) {
			req.getRequestDispatcher("faile.jsp").forward(req, resp);
		}else {
			req.getSession().setAttribute("login", true);
			req.getRequestDispatcher("success.jsp").forward(req, resp);
		}
		
	}
}
