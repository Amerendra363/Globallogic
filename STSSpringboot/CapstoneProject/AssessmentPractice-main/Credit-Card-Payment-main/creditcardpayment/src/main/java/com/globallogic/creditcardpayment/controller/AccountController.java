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

import com.globallogic.creditcardpayment.entity.Account;
import com.globallogic.creditcardpayment.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService accountservices; 
	
	@GetMapping("/")
	public List<Account> getAccount() {
          return accountservices.getAllAccount();
	}
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable ("id")long id) {
		return accountservices.getAccount(id);
		
	}

	@PostMapping("/")
	public String addAccount(@RequestBody Account acc) {
		accountservices.addAccount(acc);
		return "Account added successfully";
	}
    
	@PutMapping("/")
	public Account updateAccount(@RequestBody Account acc) {
		return accountservices.updateAccount(acc);
	}

	@DeleteMapping("/")
	public String removeAccount(long id) {
		accountservices.removeAccount(id);
		return "Account removed successfully";
	}
	
}


