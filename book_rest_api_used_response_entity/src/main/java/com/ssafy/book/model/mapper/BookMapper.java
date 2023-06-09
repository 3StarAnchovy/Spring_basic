package com.ssafy.book.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.book.dto.Book;

public interface BookMapper {
	/**
	 * 전체 목록 조회
	 */
	public abstract List<Book> selectAll() throws SQLException;
	
	/**
	 * 책 정보 상세 조회
	 */
	public abstract Book selectByIsbn(String isbn) throws SQLException;
	
	
	/**
	 * 책정보 등록
	 */
	public abstract void registBook(Book book) throws SQLException;
	
	/**
	 * 책정보 삭제
	 */
	public abstract void deleteByIsbn(String isbn) throws SQLException;
}
