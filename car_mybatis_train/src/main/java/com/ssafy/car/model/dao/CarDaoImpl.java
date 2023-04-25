package com.ssafy.car.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.car.dto.Car;

@Repository
public class CarDaoImpl implements CarDao {

	private Logger logger = LoggerFactory.getLogger(CarDaoImpl.class);
	
	@Autowired
	private DataSource ds;
	
	@Override
	public List<Car> selectAll() throws SQLException {
		String sql = "select * from car";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			List<Car> list = new ArrayList<Car>();
			while(rs.next()) {
				Car car = new Car();
				car.setNumber(rs.getString("number"));
				car.setModel(rs.getString("model"));
				car.setPrice(rs.getInt("price"));
				car.setBrand(rs.getString("brand"));
				list.add(car);
			}
			return list;
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}

	@Override
	public Car selectByNumber(String number) throws SQLException {
		String sql = "select * from car where number = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Car car= new Car();
				car.setNumber(rs.getString("number"));
				car.setModel(rs.getString("model"));
				car.setPrice(rs.getInt("price"));
				car.setBrand(rs.getString("brand"));
				return car;
			}
			return null;
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}

	@Override
	public void registCar(Car car) throws SQLException {
		String sql = "insert into car values (?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getNumber());
			pstmt.setString(2, car.getModel());
			pstmt.setInt(3, car.getPrice());
			pstmt.setString(4, car.getBrand());
			int result = pstmt.executeUpdate();
			logger.debug("등록된 행의 수 : {}", result);
		} finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}

	@Override
	public void deleteByNumber(String number) throws SQLException {
		String sql = "delete from car where number=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			int result = pstmt.executeUpdate();
			logger.debug("삭제된 행의 수 : {}", result);
		} finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}
}
