package com.ssafy.di.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e)
	{
		String msg = "알 수 없는 오류가 발생했습니다.";
		
		if(e instanceof SQLException)
		{
			msg = "db관련 오류 발생";
		}
		else if(e instanceof NullPointerException)
		{
			msg = "Null 값을 이용하여 참조";
		}
		
		System.out.println(msg);
		
		return "error/error500";
	}
}
