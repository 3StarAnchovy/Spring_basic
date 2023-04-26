package com.ssafy.book.model.service;

import java.sql.SQLException;

import com.ssafy.book.dto.User;

public interface UserService {

	/**
	 * 아이디 비밀번호로 유저정보 조회
	 */
	public abstract User login(User user) throws SQLException;
	
}
