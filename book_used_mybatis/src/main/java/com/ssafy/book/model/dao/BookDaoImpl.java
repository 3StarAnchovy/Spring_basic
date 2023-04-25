package com.ssafy.book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
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
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Book> selectAll() throws SQLException {
		//xml의 namespace.id
		return sqlSession.selectList("BookMapper.selectAll");
	}

	@Override
	public Book selectByIsbn(String isbn) throws SQLException {
		return sqlSession.selectOne("BookMapper.selectByIsbn",isbn);
	}

	@Override
	public void registBook(Book book) throws SQLException {
		sqlSession.insert("BookMapper.insertBook",book);
	}

	@Override
	public void deleteByIsbn(String isbn) throws SQLException {
		sqlSession.delete("BookMapper.deleteBook",isbn);
	}
}
