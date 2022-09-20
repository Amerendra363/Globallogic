package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	@RequestMapping("/welcome")
	public String welcome() {
		String t="this is a private page";
		return t;
	}

}
