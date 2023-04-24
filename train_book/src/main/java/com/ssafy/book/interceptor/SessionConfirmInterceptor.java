package com.ssafy.book.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class SessionConfirmInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(FirstInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		logger.info("session prehandle() 실행");

		if (session.getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath() + "/book/list");
			return false;
		} else
			return true;

		// return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
