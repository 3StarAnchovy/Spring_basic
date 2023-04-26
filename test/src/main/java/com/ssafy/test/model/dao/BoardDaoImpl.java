package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ssafy.test.dto.Board;
import com.ssafy.test.dto.Detail;


@Repository
public class BoardDaoImpl implements BoardDao {
	DataSource ds;

	@Autowired
	public BoardDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Board> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select ano, userid, issuedate, issue from attendance";

		List<Board> car_list = new ArrayList<Board>();

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board car = new Board();
				car.setAno(rs.getString("ano"));
				car.setUserid(rs.getString("userid"));
				car.setIssuedate(rs.getString("issuedate"));
				car.setIssue(rs.getString("issue"));
				car_list.add(car);
				System.out.println(car);
			}
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}

		return car_list;
	}


	@Override
	public Detail selectByAno(String ano) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.ano, u.userid, u.name, u.rclass, u.rname, a.issuedate, a.issue from userinfo u inner join attendance a where u.userid = a.userid and a.ano = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Detail car = new Detail();
				car.setAno(rs.getString("ano"));
				car.setUserid(rs.getString("userid"));
				car.setIssuedate(rs.getString("issuedate"));
				car.setIssue(rs.getString("issue"));
				car.setName(rs.getString("name"));
				car.setRclass(rs.getString("rclass"));
				car.setRname(rs.getString("rname"));
				System.out.println(car + " test");
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
	public void deleteCar(String ano) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from attendance where ano = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano);
			pstmt.executeUpdate();
		} finally {

			pstmt.close();
			conn.close();
		}
		
	}

	@Override
	public void registCar(Board board) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println(board + "res");
		String sql = "insert into attendance (ano, userid, issuedate, issue) values (?,?,?,?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getAno());
			pstmt.setString(2, board.getUserid());
			pstmt.setString(3, board.getIssuedate());
			pstmt.setString(4, board.getIssue());
			
			pstmt.executeUpdate();
		} finally {
			pstmt.close();
			conn.close();
		}
		
	}
}
