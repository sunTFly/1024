package com.service;

import java.util.List;

import com.dao.UserDao;
import com.model.User;

public class UserService {
	// 查询用户
	public List<User> listUser(String name,String permission) {
		UserDao userDao = new UserDao();
		String sql;
		List<User> listUser = null;
		/*sql = "select * from user";
		listUser = userDao.listAllUser(sql);
		return listUser;*/
		if (name.equals("") || name == null) {
			if (permission.equals("全部") || permission == "全部") {
				sql = "select * from user";
				listUser = userDao.listAllUser(sql);
				return listUser;
			} else {
				sql = "select * from user where permission=?";
				listUser = userDao.listOfPermission(sql, permission);
				return listUser;
			}
		} else if (permission.equals("全部") || permission == "全部") {
			sql = "select * from user where name=?";
			listUser = userDao.listOfName(sql, name);
			return listUser;
		} else {
			sql = "select * from user where name=? and permission=?";
			listUser = userDao.listOfNameAndPermission(sql, name, permission);
			return listUser;
		}
	}

	// 更新用户信息
	public boolean updateUser(String oldName, String password, String newName) {
		UserDao userDao = new UserDao();
		String sql = "update user set name=?,password=? where name=?";
		return userDao.updatUser(sql, oldName, password, newName);
	}

	// 添加用户
	public boolean createUser(String name, String password, String permission, String creatTime) {
		UserDao userDao = new UserDao();
		String sql = "insert into user (name,password,permission,creatTime) values(?,?,?,?)";
	//	System.out.println(name+":"+password+":"+permission+":"+creatTime);
		return userDao.createUser(sql, name, password, permission, creatTime);
	}
	// 删除用户
	public boolean deleteUser(String name) {
		UserDao userDao = new UserDao();
		String sql = "delete from user where name=?";
		//System.out.println(name);
		return userDao.deleteUser(sql, name);
	}
}
