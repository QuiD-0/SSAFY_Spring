package com.webmvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	String driver = "com.mysql.cj.jdbc.Driver";		
	String url = "jdbc:mysql://localhost:3306/scottdb?characterEncoding=UTF-8&serverTimezone=UTC";		
	String user = "scott";
	String password = "tiger";	

	private static DBUtil instance = new DBUtil();

	private DBUtil() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public void close(AutoCloseable... closeables) {
		for (AutoCloseable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
