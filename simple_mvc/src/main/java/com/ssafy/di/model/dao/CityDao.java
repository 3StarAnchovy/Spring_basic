package com.ssafy.di.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.di.dto.City;

public interface CityDao {
	
	//city 목록 조회
	public abstract List<City> selectAll() throws SQLException;
	
	//city 정보 등록
	public abstract void insertCity(City city) throws SQLException;
	
	
}
