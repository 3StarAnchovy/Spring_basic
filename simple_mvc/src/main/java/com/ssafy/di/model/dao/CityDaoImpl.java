package com.ssafy.di.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.di.dto.City;
import com.ssafy.di.util.DBUtil;

@Repository
public class CityDaoImpl implements CityDao {

	//이렇게 하면, 문제가 있을때 에러가 안뜸 ㅅㅂ
//	@Autowired
//	private DBUtil dbUtil;
	
	private DBUtil dbUtil;
	//방법 1. 생성자 함수를 통해 의존성 주입
	@Autowired
	public CityDaoImpl(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}
	
	//방법 2. setter 함수를 통해 의존성 주입
	
	//방법3. 
	@Override
	public List<City> selectAll() throws SQLException {
		System.out.println("CityServiceImpl.selectAll() 실행중 ");
		
		String sql = "select * from city";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			List<City> list = new ArrayList<City>();
			while(rs.next())
			{
				City city = new City();
				city.setId(rs.getInt("id"));
				city.setName(rs.getString("name"));
				city.setCountryCode(rs.getString("countryCode"));
				city.setDistrict(rs.getString("district"));
				city.setPopulation(rs.getInt("population"));
				
				list.add(city);
			}
			
			return list;
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		
	}

	@Override
	public void insertCity(City city) throws SQLException {
		String sql = "insert into city (name,countrycode,district,population) values (?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, city.getName());
			pstmt.setString(2, "AFG");
			pstmt.setString(3, city.getDistrict());
			pstmt.setInt(4, city.getPopulation());
			
			int result = pstmt.executeUpdate();

			System.out.println(result);
			
			
		} finally {
			dbUtil.close(rs,pstmt,conn);
		}
	}

}
