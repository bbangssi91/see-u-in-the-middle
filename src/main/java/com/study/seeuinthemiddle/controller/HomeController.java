package com.study.seeuinthemiddle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@GetMapping(value = "/")
	public String index() {
		log.info("===== index 메인페이지 =====");
		return "index";
	}
	
}
