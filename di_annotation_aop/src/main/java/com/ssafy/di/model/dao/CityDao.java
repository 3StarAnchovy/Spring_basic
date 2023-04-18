package com.ssafy.di.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.di.dto.City;

public interface CityDao {
	public abstract List<City> selectAll() throws SQLException;
}
