package com.ssafy.book.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.book.dto.Book;
import com.ssafy.book.model.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	private Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	/**
	 * 책 전체 목록 조회 요청
	 * @throws SQLException 
	 */
	@GetMapping("/list")
	public String getBookListPage(Model model) throws SQLException {
		
		//책 목록 데이터 조회
		List<Book> bookList = bookService.selectAll();
		
		//전달할 데이터 담기
		model.addAttribute("bookList", bookList);
		
		return "book/list";
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
	@PostMapping("/regist")
	public String registBook(@ModelAttribute Book book) throws SQLException {
		
		bookService.registBook(book);
		
		return "redirect:/book/list";
	}
	
	/**
	 * 책 상세 조회 요청
	 * @throws SQLException 
	 */
	@GetMapping("/detail")
	public String getBookListPage(@RequestParam String isbn ,Model model) throws SQLException {
		
		//책 데이터 조회
		Book book = bookService.selectByIsbn(isbn);
		
		//전달할 데이터 담기
		model.addAttribute("book", book);
		
		return "book/detail";
	}
	
	
	/**
	 * 삭제요청 처리 
	 * @throws SQLException 
	 */
	@PostMapping("/delete")
	public String deleteBooks(@RequestParam String[] isbn) throws SQLException {

		logger.debug("삭제할 isbn : {}", Arrays.toString(isbn));
		
		bookService.deleteByIsbn(isbn);
		
		return "redirect:/book/list";
	}
	
	
}
