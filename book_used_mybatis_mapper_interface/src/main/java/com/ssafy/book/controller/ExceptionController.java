package com.ssafy.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

	//모든 예외를 처리할 메소드
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		e.printStackTrace();
		model.addAttribute("msg", e.getMessage());
		return "error/500";
	}
	
	//404 (NoHandlerFoundException)
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String noHandlerFoundExceptionHandler(Exception e, Model model) {
		e.printStackTrace();
		model.addAttribute("msg", e.getMessage());
		return "error/404";
	}
	
	
}
