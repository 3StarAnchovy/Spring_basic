package com.ssafy.di.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.di.dto.City;
import com.ssafy.di.model.dao.CityDao;

public class CityServiceImpl implements CityService {

	private CityDao cityDao;

	public CityServiceImpl(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public List<City> selectAll() throws SQLException {
		return cityDao.selectAll();
	}

}
