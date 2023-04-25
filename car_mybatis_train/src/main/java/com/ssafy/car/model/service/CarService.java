package com.ssafy.car.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.car.dto.Car;

public interface CarService {

	/**
	 * 전체 목록 조회
	 */
	public abstract List<Car> selectAll() throws SQLException;
	
	/**
	 * 차  정보 상세 조회
	 */
	public abstract Car selectByNumber(String no) throws SQLException;
	
	/**
	 * 차 정보 등록
	 */
	public abstract void registCar(Car car) throws SQLException;
	
	/**
	 * 차 정보 삭제
	 */
	public abstract void deleteByNumber(String[] no) throws SQLException;
	
}
