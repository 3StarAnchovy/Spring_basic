package com.ssafy.book_mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DBUtil {

	// �뱶�씪�씠踰� �룞�쟻 濡쒕뵫
	public DBUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// �뿰寃고븯湲�

	public Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/bookdb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "ssafy";
		String password = "ssafy";

		return DriverManager.getConnection(url, user, password);
	}
	// �옄�썝 諛섎궔

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
