package com.ssafy.car.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.car.dto.User;
import com.ssafy.car.model.dao.UserDao;
import com.ssafy.car.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public User login(User user) throws SQLException {
		return userMapper.login(user);
	}
}
