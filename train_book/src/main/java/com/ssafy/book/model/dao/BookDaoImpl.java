
package com.ssafy.book.model.dao;

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

import com.ssafy.book.dto.Book;

@Repository
public class BookDaoImpl implements BookDao {

	private Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

	@Autowired
	private DataSource ds;

	@Override
	public List<Book> selectAll() throws SQLException {
		String sql = "select * from book";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			List<Book> list = new ArrayList<Book>();
			while (rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				list.add(book);
			}
			return list;
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
	}

	@Override
	public Book selectByIsbn(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registBook(Book book) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByIsbn(String isbn) throws SQLException {
		String sql = "delete from book where isbn=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			int result = pstmt.executeUpdate();
			logger.debug("삭제된 행의 수 : {}", result);
		} finally {
			pstmt.close();
			conn.close();
		}
	}
}
