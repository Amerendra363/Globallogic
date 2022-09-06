package com.globallogic.creditcardpayment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.creditcardpayment.entity.Role;
import com.globallogic.creditcardpayment.services.RoleService;

@RestController
@RequestMapping("/Role")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@GetMapping("/")
	public List<Role> getRole() {
          return roleService.getRole();
	}
	
	@PostMapping("/add")		
	public String createNewRole(@RequestBody  Role role)
	{
		roleService.createNewRole(role); 
		return "Role added";
	}

}
