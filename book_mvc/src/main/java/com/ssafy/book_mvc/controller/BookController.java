package com.ssafy.book_mvc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.book_mvc.model.dto.Book;
import com.ssafy.book_mvc.model.service.BookService;

@Controller
public class BookController {
	
	BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	/* 
	 * 조회
	 */
	@GetMapping("/list")
	public String getBookList(Model model) throws SQLException
	{
		System.out.println("list controller 접근");
		List<Book> result = bookService.getBookList();
		
		model.addAttribute("bookList", result);
		return "bookList";
	}
	
	/*
	 * 등록
	 */
	@GetMapping("/regist")
	public String getRegistPage()
	{
		return "regist";
	}
	
	@PostMapping("/registAction")
	public String registBook(@ModelAttribute Book book) throws SQLException
	{
		System.out.println("registAction 접근");
		bookService.insertBook(book);
		return "redirect:/list";
	}
}
