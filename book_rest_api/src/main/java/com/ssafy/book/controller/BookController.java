package com.ssafy.book.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.book.dto.Book;
import com.ssafy.book.model.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

	private Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	/**
	 * 책 전체 목록 조회 요청
	 * @throws SQLException 
	 */
	@GetMapping("")
	@ResponseBody //리턴값을 바디에 담아주는 어노테이션
	public List<Book> getBookListPage(Model model) throws SQLException {

		//책 목록 데이터 조회
		List<Book> bookList = bookService.selectAll();
		//if(true) throw new RuntimeException("runtime");
		
		//전달할 데이터 담기
		return bookList;
	}
	
	/**
	 * 등록 페이지 이동 
	 * @throws SQLException 
	 */
	@GetMapping("/regist-page")
	public String getRegistPage() {
		return "book/regist";
	}
	
	/**
	 * 등록
	 * @throws SQLException 
	 */
	@PostMapping("")
	@ResponseBody
	public void registBook(@RequestBody Book book) throws SQLException {
		log.info(book.toString());
		bookService.registBook(book);
		
		
	}
	
	/**
	 * 책 상세 조회 요청
	 * @throws SQLException 
	 */
	@GetMapping("/{isbn}")
	@ResponseBody
	public Book getBookListPage(@PathVariable String isbn) throws SQLException {
		
		//책 데이터 조회
		Book book = bookService.selectByIsbn(isbn);
		
		return book;
	}
	
	
	/**
	 * 삭제요청 처리 
	 * @throws SQLException 
	 */
	@DeleteMapping("/{isbn}")
	@ResponseBody
	public void deleteBooks(@PathVariable String[] isbn) throws SQLException {

		logger.debug("삭제할 isbn : {}", Arrays.toString(isbn));
		bookService.deleteByIsbn(isbn);
	}
	
	
}
