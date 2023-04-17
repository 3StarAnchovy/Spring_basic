package com.ssafy.di.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.di.dto.City;
import com.ssafy.di.model.dao.CityDao;

public class CityServiceImpl implements CityService {

	private CityDao cityDao;

	// 방법 1. 생성자 함수를 통한 의존성 주입
	public CityServiceImpl(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public List<City> selectAll() throws SQLException {
		return cityDao.selectAll();
	}

}
