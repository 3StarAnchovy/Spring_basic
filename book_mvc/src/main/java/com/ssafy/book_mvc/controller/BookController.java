package com.ssafy.book_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
	/* 
	 * 조회
	 */
	@GetMapping("/list")
	public String getBookList()
	{
		return "bookList";
	}
	
	/*
	 * 등록
	 */
	@GetMapping("/regist")
	public String getRegistPage()
	{
		return "registPage";
	}
	
	@PostMapping("/registAction")
	public String registBook()
	{
		return null;
	}
}
