package com.globallogic.creditcardpayment.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.creditcardpayment.entity.User;
import com.globallogic.creditcardpayment.services.UserService;
import com.globallogic.creditcardpayment.servicesImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

//	@Autowired
//	UserServiceImpl userService;

//	@GetMapping("/showUser")
//	public List<User> showUser() {
//		return userService.showUser();
//	}
//
//	@GetMapping("/adminSignin/id/{id}/password/{password}")
//	public String adminLogin(@PathVariable("id") String id, @PathVariable("password") String password) {
//		return userService.adminSignIn(id, password);
//	}
//
//	@GetMapping("/customerSignin/id/{id}/password/{password}")
//	public String customerLogin(@PathVariable("id") String id, @PathVariable("password") String password) {
//		return userService.customerSignIn(id, password);
//	}
//
//	@PostMapping("/addUser")
//	public String addUser(@RequestBody User user) {
//		return userService.addUser(user);
//	}
//
//	@PutMapping("/updateUser")
//	public String updateUser(@RequestBody User user) {
//		return userService.updateUser(user);
//	}
//
//	@DeleteMapping("/deleteUser/{id}")
//	public String deleteUser(@PathVariable("id") long id) {
//		return userService.deleteUser(id);
//	}

	@Autowired
	private UserServiceImpl userService;
	@PostConstruct
    public void initRolesAndUser() {
        userService.initRolesAndUser();
    }
	@PostMapping({"/registerNewUser"})
	public User registerNewUser(@RequestBody User user) {
	 return	userService.registerNewUser(user);
	}
	@GetMapping({"/AdminLoginIn"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This URL is only accessible to the Admin";
	}
	@GetMapping({"/UserLoginIn"})
	 @PreAuthorize("hasRole('User')")
	public String forUser(){
		return "This URL is only accessible to the User";
	}
	
	
}
