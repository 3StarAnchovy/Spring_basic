package com.ssafy.car.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.car.dto.User;
import com.ssafy.car.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, Model model, HttpSession session) throws SQLException
	{
		User userInfo = new User();
		
		userInfo = userService.login(user);
		
		if(userInfo != null)
		{
			session.setAttribute("userInfo", userInfo);
			return "regist";
		}
		
		else {
			model.addAttribute("msg", "응애 틀렸어요");
			return "home";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "home";
	}
}
