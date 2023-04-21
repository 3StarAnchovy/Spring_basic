package com.ssafy.car.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.car.dto.User;
import com.ssafy.car.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User login(User user) throws SQLException {
		return userDao.login(user);
	}

	@Override
	public void logout() throws SQLException {
		// TODO Auto-generated method stub

	}

}
