package com.ssafy.di.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.di.dto.City;
import com.ssafy.di.model.dao.CityDao;

@Service
public class CityServiceImpl implements CityService {

//	@Autowired
//	private CityDao cityDao;
	private CityDao cityDao;

	// 방법 1. 생성자 함수를 통한 의존성 주입
	@Autowired
	public CityServiceImpl(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public List<City> selectAll() throws SQLException {
		
		System.out.println("CityServiceImpl.selectAll() 실행중 ");
		return cityDao.selectAll();
	}

	@Override
	public void insertCity(City city) throws SQLException {
		cityDao.insertCity(city);
		
	}

}
