package com.example.BookStore.controller;

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

import com.example.BookStore.entity.admin;
import com.example.BookStore.service.adminser;
import com.example.BookStore.service.signinser;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	adminser service;
	@Autowired
	signinser serv;

	@GetMapping("/{id}/{pass}/{email}")
	public String signupcheck(@PathVariable("id") long id, @PathVariable("pass") String pass,
			@PathVariable("email") String email) {
		return service.sucessSignin(id, email, pass);
	}

	@GetMapping("/")
	public List<admin> details() {
		return service.showdet();
	}

	@PostMapping("/")
	public String adddetails(@RequestBody admin s) {
		return service.admi(s);
	}

	@PutMapping("/")
	public String updatedetails(@RequestBody admin s) {
		return service.update(s);
	}

	@DeleteMapping("/{id}")

	public String deletedetails(@PathVariable("id") long id) {
		return service.delete(id);
	}

}