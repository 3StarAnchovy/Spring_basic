package com.ssafy.car.model.dao;

import java.sql.SQLException;
import com.ssafy.car.dto.User;

public interface UserDao {
	//로그인
	public User login(User user) throws SQLException;
	
	//로그아웃
	public void logout() throws SQLException;
}
