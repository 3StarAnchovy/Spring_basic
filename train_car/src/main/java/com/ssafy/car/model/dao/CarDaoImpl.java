package com.ssafy.car.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.car.dto.Car;

@Repository
public class CarDaoImpl implements CarDao {

	DataSource ds;

	@Autowired
	public CarDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Car> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select number, model, price, brand from car";

		List<Car> car_list = new ArrayList<Car>();

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Car car = new Car();
				car.setNumber(rs.getString("number"));
				car.setModel(rs.getString("model"));
				car.setPrice(rs.getInt("price"));
				car.setBrand(rs.getString("brand"));
				car_list.add(car);
			}
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}

		return car_list;
	}

	@Override
	public Car selectByNumber(String number) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select number, model, price, brand from car where number = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Car car = new Car();
				car.setNumber(rs.getString("number"));
				car.setModel(rs.getString("model"));
				car.setPrice(rs.getInt("price"));
				car.setBrand(rs.getString("brand"));
				return car;
			}
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		return null;
	}

	@Override
	public void registCar(Car car) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into car (number, model, price, brand) values (?,?,?,?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getNumber());
			pstmt.setString(2, car.getModel());
			pstmt.setInt(3, car.getPrice());
			pstmt.setString(4, car.getBrand());
			
			pstmt.executeUpdate();
		} finally {
			pstmt.close();
			conn.close();
		}

	}

	@Override
	public void deleteCar(String number) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from car where number = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			pstmt.executeUpdate();
		} finally {

			pstmt.close();
			conn.close();
		}
	}

}
