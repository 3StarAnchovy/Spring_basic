package com.ssafy.book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.book.dto.User;

@Repository
public class UserDaoImpl implements UserDao {

	DataSource ds;
	@Autowired
	public UserDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public User login(User user) throws SQLException {
		String sql = "select id, name, address from user where id = ? and password = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				User userInfo = new User();
				userInfo.setId(rs.getString("id"));
				userInfo.setName(rs.getString("name"));
				userInfo.setAddress(rs.getString("address"));
				
				return userInfo;
			}
			
			return null;
		}finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
		
	}

}
