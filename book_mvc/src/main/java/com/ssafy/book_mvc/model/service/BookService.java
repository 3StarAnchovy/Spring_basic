package com.ssafy.book_mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.book_mvc.model.dto.Book;

public interface BookService {
	public abstract List<Book> getBookList() throws SQLException;
	public void insertBook(Book book) throws SQLException;
}
