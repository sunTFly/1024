package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.until.JDBCUntil;

public class loginService {
	public boolean login(String uname, String upwd) {
		boolean flag = false;
		try {
			String sql = "select * from testtable where name=? and password=?";
			Connection conn = JDBCUntil.getConnection();
			// sql注入
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2, upwd);
			//返回结果集
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(flag);
		return flag;
	}
}
