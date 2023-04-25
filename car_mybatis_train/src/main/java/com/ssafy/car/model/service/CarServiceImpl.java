package com.ssafy.car.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.car.dto.Car;
import com.ssafy.car.model.mapper.CarMapper;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarMapper carMapper;
	
	@Override
	public List<Car> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return  carMapper.selectAll();
	}

	@Override
	public Car selectByNumber(String no) throws SQLException {
		// TODO Auto-generated method stub
		return  carMapper.selectByNumber(no);
	}

	@Override
	public void registCar(Car car) throws SQLException {
		// TODO Auto-generated method stub
		 carMapper.registCar(car);
	}

	@Override
	public void deleteByNumber(String[] no) throws SQLException {
		for(String n : no) 
			 carMapper.deleteByNumber(n);
	}
}





