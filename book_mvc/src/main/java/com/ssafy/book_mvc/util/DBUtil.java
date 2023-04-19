package com.ssafy.book_mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DBUtil {

	// 드라이버 동적 로딩
	public DBUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 연결하기

	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/world?ServerTimeZone=UTC";
		String user = "ssafy";
		String password = "ssafy";

		return DriverManager.getConnection(url, user, password);
	}
	// 자원 반납

	public void close(AutoCloseable... autoCloseables) {
		for (AutoCloseable obj : autoCloseables) {
			if (obj != null)
				try {
					obj.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}
