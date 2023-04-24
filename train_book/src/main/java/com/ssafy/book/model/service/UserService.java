package com.ssafy.book.model.service;

import java.sql.SQLException;

import com.ssafy.book.dto.User;

public interface UserService {
	public abstract User login(User user) throws SQLException;
}
