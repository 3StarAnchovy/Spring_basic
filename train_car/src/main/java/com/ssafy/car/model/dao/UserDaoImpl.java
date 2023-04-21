package com.ssafy.car.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.car.dto.User;

@Repository
public class UserDaoImpl implements UserDao {

	DataSource ds;
	
	@Autowired
	public UserDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public User login(User user) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select id,name from user where id = ? and password = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getId());
			pstmt.setString(2,user.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				User userInfo = new User();
				userInfo.setId(rs.getString("id"));
				userInfo.setName(rs.getString("name"));
				
				return userInfo;
			}
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		return null;
	}

	@Override
	public void logout() throws SQLException {
		// TODO Auto-generated method stub

	}

}
