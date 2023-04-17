package com.ssafy.di.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public DBUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		String user = "ssafy";
		String pwd = "ssafy";
		String url = "jdbc:mysql://localhost:3306/world?ServerTimeZone=UTC";

		return DriverManager.getConnection(url, user, pwd);
	}

	public void close(AutoCloseable... autoCloseables) {
		for (AutoCloseable obj : autoCloseables) {
			if (obj != null)
				try {
					obj.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
