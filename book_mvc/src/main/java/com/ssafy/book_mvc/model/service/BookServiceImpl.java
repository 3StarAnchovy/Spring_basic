package com.ssafy.book_mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book_mvc.model.dao.BookDao;
import com.ssafy.book_mvc.model.dao.BookDaoImpl;
import com.ssafy.book_mvc.model.dto.Book;

@Service
public class BookServiceImpl implements BookService {

	BookDao bookdao;
	
	@Autowired
	public BookServiceImpl(BookDao bookdao) {
		this.bookdao =bookdao;
	}
	@Override
	public List<Book> getBookList() throws SQLException {
		return bookdao.getBookList();
	}
	@Override
	public void insertBook(Book book) throws SQLException {
		bookdao.insertBook(book);
		
	}

}
