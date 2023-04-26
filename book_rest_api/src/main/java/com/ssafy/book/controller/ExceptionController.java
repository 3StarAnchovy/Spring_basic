package com.ssafy.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ExceptionController {

	//모든 예외를 처리할 메소드
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception e) {
		e.printStackTrace();
		
		//return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
		//return ResponseEntity.ok().body(e.getMessage());
		//return ResponseEntity.internalServerError().body(e.getMessage());
		//return ResponseEntity.status(500).body(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
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
