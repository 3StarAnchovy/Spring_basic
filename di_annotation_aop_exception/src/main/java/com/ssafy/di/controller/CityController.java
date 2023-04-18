package com.ssafy.di.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.di.dto.City;
import com.ssafy.di.model.dao.CityDao;
import com.ssafy.di.model.service.CityService;

/*
 * 컨트롤러에 접근하는 경로
 * 컨트롤러 내부의 메소드로 접근하는 경로
 */

@Controller
@RequestMapping("/city")
public class CityController {
	
	private CityService cityService;
	
	
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@Autowired
	@Qualifier("cityDaoImpl")
	private CityDao cityDao;


	@RequestMapping("/list-page")
	public String getCityListPage() throws SQLException
	{
		System.out.println("ㅎㅇㅎㅇ");
		String cityServiceName = cityService.getClass().getName();
		String cityDaoName = cityDao.getClass().getName();
		List<City> cityList = cityService.selectAll();
		System.out.println(cityList);
		
		System.out.println(cityServiceName);
		System.out.println(cityDaoName);
		
		//home.jsp로 forwarding
		return "home";
	}
	
	//로컬에서 핸들링
//	@ExceptionHandler(SQLException.class)
//	public String sqlExceptionHandler(Exception e)
//	{
//		System.out.println("SQL Exception 핸들링");
//		System.out.println("예외 메시지 : " + e.getMessage());
//		
//		return "error/error500";
//	}
}
