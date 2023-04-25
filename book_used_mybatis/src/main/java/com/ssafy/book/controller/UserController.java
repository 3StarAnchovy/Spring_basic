package com.ssafy.book.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.book.dto.User;
import com.ssafy.book.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	/**
	 * 로그인 요청 처리
	 * @throws SQLException 
	 */
	@PostMapping("/login")
	public String login(
			@ModelAttribute User user, 
			HttpSession session,
			Model model
			) throws SQLException {
		User userInfo = userService.login(user);
		
		if(userInfo!=null) 
		{
			session.setAttribute("userInfo", userInfo);
			return "redirect:/";
		}
		else {
			model.addAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "home";
		}
	}
	
	/**
	 * 로그아웃 요청 처리
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
