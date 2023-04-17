package com.ssafy.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.di.model.dao.CityDaoImpl;
import com.ssafy.di.model.service.CityServiceImpl;
import com.ssafy.di.util.DBUtil;

@Configuration
public class JavaConfig {
	
	//DBUtil 빈 등록
	@Bean
	public DBUtil getDbUtil()
	{
		return new DBUtil();
	}
	
	//cityDaoImpl 빈 등록
	@Bean
	public CityDaoImpl getCityDaoImpl()
	{
		return new CityDaoImpl(getDbUtil());
	}
	
	//cityServiceImpl 
	@Bean
	public CityServiceImpl getCityServiceImpl()
	{
		return new CityServiceImpl(getCityDaoImpl());
	}
}
