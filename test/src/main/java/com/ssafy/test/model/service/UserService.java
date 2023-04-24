package com.ssafy.test.model.service;

import java.sql.SQLException;

import com.ssafy.test.dto.User;

public interface UserService {
	public User login(User user) throws SQLException;
}
