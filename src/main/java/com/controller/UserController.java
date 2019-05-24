package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserController extends HttpServlet {
	UserService userService = new UserService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = req.getParameter("operation");
		// 查找操作
		/*
		 * List<User> listuser = userService.listUser(); new JSONArray(); JSONArray
		 * jsonUser = JSONArray.fromObject(listuser); //
		 * System.out.println(jsonUser.toString()); try {
		 * resp.setCharacterEncoding("utf8"); PrintWriter pw = resp.getWriter();
		 * pw.write(jsonUser.toString()); pw.flush(); pw.close(); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		if (operation.equals("serchUser") || operation == "serchUser") {
			String name = req.getParameter("uname");
			String permission = req.getParameter("permission");
			// System.out.println(name+":"+permission);
			List<User> listuser = userService.listUser(name, permission);
			new JSONArray();
			JSONArray jsonUser = JSONArray.fromObject(listuser);
			// System.out.println(jsonUser.toString());
			try {
				resp.setCharacterEncoding("utf8");
				PrintWriter pw = resp.getWriter();
				pw.write(jsonUser.toString());
				pw.flush();
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 更新操作
		if (operation.equals("updateUser") || operation == "updateUser") {
			String oldName = req.getParameter("oldName");
			String password = req.getParameter("password");
			String newName = req.getParameter("newName");
			boolean flag = userService.updateUser(oldName, password, newName);
			if (!flag) {
				req.getRequestDispatcher("faile.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("yhcx.jsp").forward(req, resp);
			}
		}
		// 添加用户
		if (operation.equals("creatUser") || operation == "creatUser") {
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String permission = "普通用户";
			Date getDate = Calendar.getInstance().getTime();
			String creatTime = new SimpleDateFormat("yyyy-MM-dd").format(getDate);
			boolean flag = userService.createUser(name, password, permission, creatTime);
			if (!flag) {
				req.getRequestDispatcher("faile.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("yhcx.jsp").forward(req, resp);
			}
		}
		// 删除用户
		if (operation.equals("deleteUser") || operation == "deleteUser") {
			String name = req.getParameter("dname");
			JSONArray json = JSONArray.fromObject(name);
			if (json.size() > 0) {
				for (int i = 0; i < json.size(); i++) {
					JSONObject job = json.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成 json 对象
					System.out.println(job.getString("name")); // 得到 每个对象中的属性值
					boolean flag = userService.deleteUser(job.getString("name"));
					if (!flag) {
						try {
							resp.setCharacterEncoding("utf8");
							PrintWriter pw = resp.getWriter();
							pw.write("删除失败");
							pw.flush();
							pw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						try {
							resp.setCharacterEncoding("utf8");
							PrintWriter pw = resp.getWriter();
							pw.write("删除成功");
							pw.flush();
							pw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		}
	}
}
