package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.MenuDao;
import com.model.Children;
import com.model.Menu;
import com.model.User;
import com.until.JDBCUntil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShowMenuService {
	public JSONArray showMenu() {
		MenuDao menudao = new MenuDao();
		// 更目录数组
		JSONArray tree = new JSONArray();
		// 更目录数据
		JSONObject root = new JSONObject();
		List<Menu> listmenu = menudao.getFristMenu();
		for (Menu menu : listmenu) {
			root.put("id", menu.getMid());
			root.put("text", menu.getMname());
			root.put("state", "open");
			// 二级目录素组
			JSONArray jach = new JSONArray();
			List<Children> childrens = menudao.getChildrenMenu(menu.getMid());
			for (Children children : childrens) {
				// 二级目录数据
				JSONObject ch = new JSONObject();
				ch.put("id", children.getCid());
				ch.put("text", children.getCname());
				ch.put("attributes", children.getAttributes());
				// ch.put("state", "open");
				jach.add(ch);
			}
			root.put("children", jach);
			tree.add(root);
		}

		return tree;
	}
}
