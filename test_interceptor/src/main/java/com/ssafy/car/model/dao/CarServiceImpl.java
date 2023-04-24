package com.ssafy.car.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.car.dto.Car;

@Service
public class CarServiceImpl implements CarService {

	CarDao carDao;

	@Autowired
	public CarServiceImpl(CarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public List<Car> selectAll() throws SQLException {
		return carDao.selectAll();
	}

	@Override
	public Car selectByNumber(String number) throws SQLException {
		return carDao.selectByNumber(number);
	}

	@Override
	public void registCar(Car car) throws SQLException {
		carDao.registCar(car);

	}

	@Override
	public void deleteCar(String[] number) throws SQLException {
		for (String n : number) {
			carDao.deleteCar(n);
		}

	}

}
