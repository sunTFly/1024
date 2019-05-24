package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Children;
import com.model.Menu;
import com.until.JDBCUntil;

public class MenuDao {
	public List<Menu> getFristMenu() {
		List<Menu> fristmenus = new ArrayList<Menu>();
		String sql = "select * from menu";
		Connection conn = null;
		try {
			if (conn == null || conn.isClosed()) {
				conn = JDBCUntil.getConnection();
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMname(rs.getString("mname"));
				fristmenus.add(menu);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return fristmenus;
	}

	public List<Children> getChildrenMenu(int mid) {
		List<Children> secedetmenus = new ArrayList<Children>();
		String sql = "select * from children where mid=?";
		Connection conn = null;
		try {
			if (conn == null || conn.isClosed()) {
				conn = JDBCUntil.getConnection();
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Children children = new Children();
				children.setMid(rs.getInt("mid"));
				children.setCname(rs.getString("cname"));
				children.setAttributes(rs.getString("attributes"));
				secedetmenus.add(children);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return secedetmenus;
	}
}
