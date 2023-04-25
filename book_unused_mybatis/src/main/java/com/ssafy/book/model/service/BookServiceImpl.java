package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.dto.Book;
import com.ssafy.book.model.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return bookDao.selectAll();
	}

	@Override
	public Book selectByIsbn(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		return bookDao.selectByIsbn(isbn);
	}

	@Override
	public void registBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		bookDao.registBook(book);
	}

	@Override
	public void deleteByIsbn(String[] isbn) throws SQLException {
		for(String i : isbn) 
			bookDao.deleteByIsbn(i);
	}
}





