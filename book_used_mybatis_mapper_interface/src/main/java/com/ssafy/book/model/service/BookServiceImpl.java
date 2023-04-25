package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.dto.Book;
import com.ssafy.book.model.dao.BookDao;
import com.ssafy.book.model.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public List<Book> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return bookMapper.selectAll();
	}

	@Override
	public Book selectByIsbn(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		return bookMapper.selectByIsbn(isbn);
	}

	@Override
	public void registBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		bookMapper.registBook(book);
	}

	@Override
	public void deleteByIsbn(String[] isbn) throws SQLException {
		for(String i : isbn) 
			bookMapper.deleteByIsbn(i);
	}
}





