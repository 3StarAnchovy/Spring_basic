package com.ssafy.car.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.car.dto.Car;
import com.ssafy.car.model.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	CarService carService;
	
	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping("")
	public ResponseEntity<?> selectAll() throws SQLException
	{
		List<Car> car_list = carService.selectAll();
		return ResponseEntity.status(200).body(car_list);
	}
	
	@GetMapping("/{number}")
	public ResponseEntity<?> selectByNumber(@PathVariable String number) throws SQLException
	{
		Car car = carService.selectByNumber(number);
		return ResponseEntity.status(200).body(car);
	}
	
	@PostMapping("")
	public ResponseEntity<?> registCar(@RequestBody Car car) throws SQLException
	{
		System.out.println(car);
		carService.registCar(car);
		return ResponseEntity.status(200).build();
	}
	
	@DeleteMapping("/{number}")
	public ResponseEntity<?> deleteByNumber(@PathVariable String[] number) throws SQLException
	{
		carService.deleteByNumber(number);
		return ResponseEntity.status(200).build();
	}
}
