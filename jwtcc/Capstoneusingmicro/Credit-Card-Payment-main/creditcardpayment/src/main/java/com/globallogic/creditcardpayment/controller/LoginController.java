package com.globallogic.creditcardpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.creditcardpayment.services.UserService;

@RestController
@RequestMapping("/cc/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/adminLogin/id/{id}/password/{password}")
	public String adminLogin(@PathVariable("id") String id,@PathVariable("password") String password) {
		
		return userService.adminSignIn(id, password);
		
	}
	
	@GetMapping("/customerLogin/id/{id}/password/{password}")
	public String customerLogin(@PathVariable("id") String id,@PathVariable("password") String password) {
		
		return userService.customerSignIn(id, password);
		
	}

}
