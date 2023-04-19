package com.ssafy.di.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	// 도시정보 추가 페이지 반환
	@GetMapping("/regist-page")
	public String getRegistPage() {
		return "cityInsert";
	}
	
//	@PostMapping("/regist")
//	public ModelAndView registCity(ModelAndView mav) throws SQLException
//	{
//		
//		System.out.println("등록 데이터 : " + city.toString());
//		//System.out.println(map);
//		cityService.insertCity(city);
//		return "redirect:/city/list-page";
//	}

	@PostMapping("/regist")
	public String registCity(//@RequestParam Map<String, String> map
			@ModelAttribute City city) throws SQLException
	{
		System.out.println("등록 데이터 : " + city.toString());
		//System.out.println(map);
		cityService.insertCity(city);
		return "redirect:/city/list-page";
	}
	
	//도시 정보 추가 요청 처리
//	@PostMapping("/regist") // name -> 프론트에서 보낼때 key값
//	public String registCity(@RequestParam(name = "name") String name,
//			@RequestParam(name = "district") String district,
//			@RequestParam(name = "population") int population) throws SQLException
//	{
//		City city = new City();
//		city.setName(name);
//		city.setDistrict(district);
//		city.setPopulation(population);
//		
//		//city service
//		cityService.insertCity(city);
//		
//		//포워드 말고 리다이렉트
//		return "redirect:/city/list-page";
//	}
	
	@GetMapping("/list-page")
	public String getCityListPage(Model model) throws SQLException {
		List<City> cityList = cityService.selectAll();
		//System.out.println(cityList);

		// view에 넘길 데이터를 model에 담기
		model.addAttribute("cityList", cityList);

		return "list";
	}
	
//	@GetMapping("/list-page")
//	public ModelAndView getCityListPage(ModelAndView mv) throws SQLException {
//		List<City> cityList = cityService.selectAll();
//		//System.out.println(cityList);
//
//		// view에 넘길 데이터를 model에 담기
//		mv.addObject("cityList", cityList);
//		mv.setViewName("list");
//
//		return mv;
//	}
}
