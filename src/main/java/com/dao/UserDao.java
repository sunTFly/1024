package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;
import com.until.JDBCUntil;

public class UserDao {
	// 查询全部
	public List<User> listAllUser(String sql) {
		List<User> listUser = new ArrayList<User>();
		Connection conn = null;
		try {
			PreparedStatement ps = null;
			if (conn == null || conn.isClosed()) {
				conn = JDBCUntil.getConnection();
				ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					User user = new User();
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setPermission(rs.getString("permission"));
					user.setCreatTime(rs.getString("creatTime"));
					listUser.add(user);
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listUser;
	}

	// 根据权限查询
	public List<User> listOfPermission(String sql, String permission) {
		List<User> listUser = new ArrayList<User>();
		Connection conn = null;
		try {
			PreparedStatement ps = null;
			if (conn == null || conn.isClosed()) {
				conn = JDBCUntil.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, permission);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					User user = new User();
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setPermission(rs.getString("permission"));
					user.setCreatTime(rs.getString("creatTime"));
					listUser.add(user);
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listUser;
	}

	// 根据姓名查询
	public List<User> listOfName(String sql, String name) {
		List<User> listUser = new ArrayList<User>();
		Connection conn = null;
		try {
			PreparedStatement ps = null;
			if (conn == null || conn.isClosed()) {
				conn = JDBCUntil.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					User user = new User();
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setPermission(rs.getString("permission"));
					user.setCreatTime(rs.getString("creatTime"));
					listUser.add(user);
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listUser;
	}

	// 根据姓名和权限查询
	public List<User> listOfNameAndPermission(String sql, String name, String permission) {
		List<User> listUser = new ArrayList<User>();
		Connection conn = null;
		try {
			PreparedStatement ps = null;
			if (conn == null || conn.isClosed()) {
				conn = JDBCUntil.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, permission);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					User user = new User();
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					user.setPermission(rs.getString("permission"));
					user.setCreatTime(rs.getString("creatTime"));
					listUser.add(user);
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listUser;
	}

	// 更新
	public boolean updatUser(String sql, String oldName, String password, String newName) {
		boolean flag = false;
		Connection conn = null;
		try {
			PreparedStatement ps = null;
			if (conn == null || conn.isClosed()) {
				try {
					conn = JDBCUntil.getConnection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps = conn.prepareStatement(sql);
				ps.setString(1, newName);
				ps.setString(2, password);
				ps.setString(3, oldName);
				ps.executeUpdate();
				flag = true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return flag;
	}

//添加用户
	public boolean createUser(String sql,String name, String password, String permission, String creatTime) {
		boolean flag = false;
		Connection conn = null;
		try {
			PreparedStatement ps = null;
			if (conn == null || conn.isClosed()) {
				try {
					conn = JDBCUntil.getConnection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, password);
				ps.setString(3, permission);
				ps.setString(4, creatTime);
				ps.execute();
				flag = true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return flag;
	}
	//删除用户
		public boolean deleteUser(String sql,String name) {
			boolean flag = false;
			Connection conn = null;
			try {
				PreparedStatement ps = null;
				if (conn == null || conn.isClosed()) {
					try {
						conn = JDBCUntil.getConnection();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ps = conn.prepareStatement(sql);
					ps.setString(1, name);
					ps.execute();
					flag = true;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return flag;
		}
}
