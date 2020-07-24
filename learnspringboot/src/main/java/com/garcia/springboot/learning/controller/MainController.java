package com.garcia.springboot.learning.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

	private static final Logger log = LogManager.getLogger(MainController.class);
			
	@GetMapping("/list")
	public String list(HttpServletResponse response) {
		log.info("list method()");
		response.setHeader("CompletedMethod", "list");
		return "list";
	}
	
	@GetMapping("/add")
	public String findModelByBrand(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("brand") String brand) {
		log.info("add method()");
		response.setHeader("CompletedMethod", "add");
		request.setAttribute("brand", brand);
		return String.format("add %s", brand);
	}
	
	@GetMapping("/{brand}")
	public String find(HttpServletRequest request, HttpServletResponse response, 
			@PathVariable("brand") String brand, 
			@RequestParam(value = "model", required = false) String model) {
		log.info("find method()");
		response.setHeader("CompletedMethod", "find");
		request.setAttribute("brand", brand);
		request.setAttribute("model", model);
		return String.format("find brand %s with model %s", brand, model);
	}

}
