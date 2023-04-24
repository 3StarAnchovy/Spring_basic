package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.test.dto.User;

@Repository
public class UserDaoImpl implements UserDao {

	DataSource ds;

	@Autowired
	public UserDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public User login(User user) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("hi");
		String sql = "select userid,position,name,rname,rclass from userinfo where userid = ? and userpw = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getUserpw());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("hi");
				User userInfo = new User();
				userInfo.setUserid(rs.getString("userid"));
				userInfo.setPosition(rs.getString("position"));
				userInfo.setName(rs.getString("name"));
				userInfo.setRname(rs.getString("rname"));
				userInfo.setRclass(rs.getInt("rclass"));
				
				System.out.println(userInfo);
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
