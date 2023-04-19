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
		String sql = "select isbn, title, price, descr, author from book";
		
		conn = dbutil.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		List<Book> result = new ArrayList<Book>();
		while(rs.next())
		{
			Book book = new Book();
			book.setIsbn(rs.getString("isbn"));
			book.setTitle(rs.getString("title"));
			book.setPrice(rs.getInt("price"));
			book.setDescr(rs.getString("descr"));
			book.setAuthor(rs.getString("author"));
			
			result.add(book);
		}
		
		return result;
	}
	
	@Override
	public void insertBook(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = "insert into book (isbn,title,price,descr,author) values (?,?,?,?,?)";
		
		conn = dbutil.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, book.getIsbn());
		pstmt.setString(2, book.getTitle());
		pstmt.setInt(3, book.getPrice());
		pstmt.setString(4, book.getDescr());
		pstmt.setString(5, book.getAuthor());
		
		rs = pstmt.executeUpdate();
	}
	
	public static void main(String[] args) throws SQLException
	{
		DBUtil dbUtil = new DBUtil();
		BookDaoImpl bookDaoImpl = new BookDaoImpl(dbUtil);
		List<Book> books = bookDaoImpl.getBookList();
		
		System.out.println(books);
	}

	
	
	
}
