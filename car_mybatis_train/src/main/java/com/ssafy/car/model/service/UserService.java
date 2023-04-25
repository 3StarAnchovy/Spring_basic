package com.ssafy.car.model.service;

import java.sql.SQLException;

import com.ssafy.car.dto.User;

public interface UserService {

	/**
	 * 아이디 비밀번호로 유저정보 조회
	 */
	public abstract User login(User user) throws SQLException;
	
}
