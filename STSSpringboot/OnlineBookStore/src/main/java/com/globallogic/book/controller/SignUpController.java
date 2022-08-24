package com.globallogic.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.book.entity.SignUp;
import com.globallogic.book.services.SignUpService;

@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	@Autowired
	SignUpService service;
	
	@GetMapping("/")
	public List<SignUp> show(){
		return service.showDetails();
	}
	
	@PostMapping("/")
	public String addSignUp(@RequestBody SignUp signUp) {
		
		return service.addSignup(signUp);
		
	}
	
	@PutMapping("/")
	public String updateSignUp(@RequestBody SignUp signUp) {
		
		return service.updateSignup(signUp);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteSignUp(@PathVariable("id") int id) {
		return service.delete(id);
	}

}
