package com.ssafy.car.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.car.dto.Car;
import com.ssafy.car.model.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {

	private Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	private CarService carService;
	
	/**
	 * 차 전체 목록 조회 요청
	 * @throws SQLException 
	 */
	@GetMapping("/list")
	public String getCarListPage(Model model) throws SQLException {
		
		//차 목록 데이터 조회
		List<Car> carList = carService.selectAll();
		
		//전달할 데이터 담기
		model.addAttribute("carList", carList);
		
		return "car/list";
	}
	
	/**
	 * 등록 페이지 이동 
	 * @throws SQLException 
	 */
	@GetMapping("/regist-page")
	public String getRegistPage() {
		return "car/regist";
	}
	
	/**
	 * 등록
	 * @throws SQLException 
	 */
	@PostMapping("/regist")
	public String registCar(@ModelAttribute Car car) throws SQLException {
		
		carService.registCar(car);
		
		return "redirect:/car/list";
	}
	
	/**
	 * 차 상세 조회 요청
	 * @throws SQLException 
	 */
	@GetMapping("/detail")
	public String getCarListPage(@RequestParam String number ,Model model) throws SQLException {
		
		//차 데이터 조회
		Car car = carService.selectByNumber(number);
		
		//전달할 데이터 담기
		model.addAttribute("car", car);
		
		return "car/detail";
	}
	
	
	/**
	 * 삭제요청 처리 
	 * @throws SQLException 
	 */
	@PostMapping("/delete")
	public String deleteCars(@RequestParam String[] number) throws SQLException {

		logger.debug("삭제할 number : {}", Arrays.toString(number));
		
		carService.deleteByNumber(number);
		
		return "redirect:/car/list";
	}
	
	
}
