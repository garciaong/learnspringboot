package com.garcia.springboot.learning.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ListInterceptor implements HandlerInterceptor {

	private static final Logger log = LogManager.getLogger(ListInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("Handling Request URI : {}", request.getRequestURI());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("Completed Request URI : {}", request.getRequestURI());
		log.info("Completed method call : {}", response.getHeader("CompletedMethod"));
		if(request.getAttribute("brand")!=null) {
			log.info("Brand : {}", request.getAttribute("brand"));
		}
		if(request.getAttribute("model")!=null) {
			log.info("Model : {}", request.getAttribute("model"));
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		log.info("Exit Request URI : {}", request.getRequestURI());
	}

}
