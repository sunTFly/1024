package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ShowMenuService;

public class MenuController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ShowMenuService showMenuService = new ShowMenuService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 有一个服务提供tree的数据
		String tree = showMenuService.showMenu().toString();
		resp.setCharacterEncoding("utf8");
		PrintWriter pw = resp.getWriter();
		pw.write(tree);
		pw.flush();
		pw.close();
	}
}
