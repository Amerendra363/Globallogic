package com.example.Jwt.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jwt.entity.User;
import com.example.Jwt.service.UserService;

@RestController
public class UserController {
 
	@Autowired
	private UserService userService;
	@PostConstruct
    public void initRolesAndUser() {
        userService.initRolesAndUser();
    }
	@PostMapping({"/jwt/registerNewUser"})
	public User registerNewUser(@RequestBody User user) {
	 return	userService.registerNewUser(user);
	}
	@GetMapping({"/jwt/forAdmin"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This URL is only accessible to the Admin";
	}
	@GetMapping({"/jwt/forUser"})
	 @PreAuthorize("hasRole('User')")
	public String forUser(){
		return "This URL is only accessible to the User";
	}
}
