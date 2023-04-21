package com.ssafy.car.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.car.dto.Car;

public interface CarService {
	// 자동차 전체조회
	public abstract List<Car> selectAll() throws SQLException;

	// 자동차 상세 조회
	public Car selectByNumber(String number) throws SQLException;

	// 자동차 등록
	public abstract void registCar(Car car) throws SQLException;


	public abstract void deleteCar(String[] number) throws SQLException;

}
