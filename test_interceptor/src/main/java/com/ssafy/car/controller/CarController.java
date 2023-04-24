package com.ssafy.car.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.car.dto.Car;
import com.ssafy.car.model.dao.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	CarService carService;
	
	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping("/list")
	public String selectAll(Model model) throws SQLException
	{
		List<Car> carList = carService.selectAll();
		model.addAttribute("carList", carList);
		return "car/list";
	}
	
	@GetMapping("/regist")
	public String registPage()
	{
		return "car/regist";
	}
	
	@PostMapping("/regist")
	public String registCar(@ModelAttribute Car car) throws SQLException
	{
		carService.registCar(car);
		return "redirect:/car/list";
	}
	
	@GetMapping("detail")
	public String selectByNumber(@RequestParam String number, Model model) throws SQLException
	{
		Car car = carService.selectByNumber(number);
		model.addAttribute("car", car);
		return "car/detail";
	}
	
	@PostMapping("/delete")
	public String deleteCar(@RequestParam String[] number) throws SQLException
	{
		System.out.println(number);
		carService.deleteCar(number);
		return "redirect:/car/list";
	}
}
