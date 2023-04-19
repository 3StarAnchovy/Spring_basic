package com.ssafy.book_mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.book_mvc.model.dto.Book;

public interface BookDao {
	public abstract List<Book> getBookList() throws SQLException;
}
