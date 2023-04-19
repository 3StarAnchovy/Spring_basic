package com.ssafy.book_mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.ssafy.book_mvc.model.dto.Book;
import com.ssafy.book_mvc.util.DBUtil;

@Repository
public class BookDaoImpl implements BookDao {
	// dbutil -> bookdao -> service -> controller;
	
	DBUtil dbutil;
	
	@Autowired
	public BookDaoImpl(DBUtil dbUtil)
	{
		this.dbutil = dbUtil;
	}
	
	public List<Book> getBookList() throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select isbn, title, price, desc, author from book";
		
		conn = dbutil.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		List<Book> result = new ArrayList<Book>();
		while(rs.next())
		{
			Book book = new Book();
			book.setIsbn(rs.getString("isbn"));
			book.setTitle(rs.getString("titme"));
			book.setPrice(rs.getInt("price"));
			book.setDesc(rs.getString("desc"));
			book.setAuthor(rs.getString("author"));
			
			result.add(book);
		}
		
		return result;
	}
	
	public static void main(String[] args) throws SQLException
	{
		ApplicationContext applicationContext = new GenericXmlApplicationContext("main\\webapp\\WEB-INF\\spring\\appServlet\\servlet-context.xml");
		// 조회 테스트
		BookDaoImpl bookDaoImpl = (BookDaoImpl)applicationContext.getBean("bookDaoImpl");
		List<Book> books = bookDaoImpl.getBookList();
		
		System.out.println(books);
		
		
	}
	
	
}
