package com.globallogic.creditcardpayment.controller;

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

import com.globallogic.creditcardpayment.entity.Admin;
import com.globallogic.creditcardpayment.entity.Payment;
import com.globallogic.creditcardpayment.services.AdminService;
import com.globallogic.creditcardpayment.services.PaymentService;

@RestController
@RequestMapping("/cc/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/adminLogin/id/{id}/password/{password}")
	public String adminLogin(@PathVariable("id") String id,@PathVariable("password") String password) {
		return adminService.adminLogin(id, password);
	}
	
	@GetMapping("/")
	public List<Admin> showAdmin(){
		return adminService.showAdmin();
		
	}
	
	@PostMapping("/")
	public List<Admin> addAdmin(@RequestBody Admin admin){
		return adminService.addAdmin(admin);
	}
	
	@PutMapping("/")
	public Admin updateAdmin(@RequestBody Admin admin){
		return adminService.updateAdmin(admin);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAdmin(@PathVariable("id") long id) {
		return adminService.deleteAdmin(id);
	}
	


}
