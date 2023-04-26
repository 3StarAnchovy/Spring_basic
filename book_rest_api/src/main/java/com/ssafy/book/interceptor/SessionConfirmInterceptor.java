package com.ssafy.book.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.book.dto.User;

public class SessionConfirmInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User userInfo = (User)session.getAttribute("userInfo");
		if(userInfo==null) {
			response.sendRedirect(request.getContextPath()+"/book/list");
			return false;
		}
		return true;
	}
	
}
