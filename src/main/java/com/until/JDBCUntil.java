package com.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class JDBCUntil {
	public static String DRIVERNAME = "com.mysql.jdbc.Driver";
	public static String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
	public static String USER = "root";
	public static String PASSWORD = "Suntengfei1996";
	public static Connection conn = null;

	public static Connection getConnection() throws Exception {
		if (conn != null) {
			return conn;
		}
		// 加载驱动
		Class.forName(DRIVERNAME);
		// 获取连接对象
		conn = DriverManager.getConnection(URL, USER, PASSWORD);

		return conn;
	}

//关闭
	public static void closeResource(Connection conn, PreparedStatement st) throws SQLException {
		st.close();
		conn.close();
	}

	public static void closeResource(Connection conn, ResultSet rs, PreparedStatement st) throws SQLException {
		st.close();
		rs.close();
		conn.close();
	}

}
