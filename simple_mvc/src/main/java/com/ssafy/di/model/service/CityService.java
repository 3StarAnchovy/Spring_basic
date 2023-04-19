package com.ssafy.di.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.di.dto.City;

public interface CityService {
	public abstract List<City> selectAll() throws SQLException;
	
	public abstract void insertCity(City city) throws SQLException;
}
