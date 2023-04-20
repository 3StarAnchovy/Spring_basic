package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.book.dto.Book;

public interface BookService {
	
	/*
	 * 조회
	 */
	public abstract List<Book> selectAll() throws SQLException;
	
	/*
	 * 상세 조회
	 */
	public abstract Book selectByIsbn(String isbn) throws SQLException;
	
	/*
	 * 책 정보등록
	 */
	public abstract void registBook(Book book) throws SQLException;
	
	/*
	 * 책 정보 삭제
	 */
	public abstract void deleteByIsbn(String[] isbn) throws SQLException;
}
