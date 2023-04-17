package com.ssafy.di.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.di.dto.City;
import com.ssafy.di.model.service.CityService;

/*
 * 컨트롤러에 접근하는 경로
 * 컨트롤러 내부의 메소드로 접근하는 경로
 */

@RequestMapping("/city")
public class CityController {
	
	private CityService cityService;
	
	
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}


	@RequestMapping("/list-page")
	public String getCityListPage() throws SQLException
	{
		System.out.println("ㅎㅇㅎㅇ");
		List<City> cityList = cityService.selectAll();
		System.out.println(cityList);
		
		//home.jsp로 forwarding
		return "home";
	}
}
