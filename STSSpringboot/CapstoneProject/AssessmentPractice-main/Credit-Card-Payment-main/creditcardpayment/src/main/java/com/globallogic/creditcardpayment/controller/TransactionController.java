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

import com.globallogic.creditcardpayment.entity.Transaction;
import com.globallogic.creditcardpayment.services.Transcationservice;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	Transcationservice transactionService;

	@GetMapping("/")
	public List<Transaction> getTransaction() {
		return transactionService.getAllTransaction();
	}

	@GetMapping("/{id}")
	public Transaction getTransaction(@PathVariable("id") long id) {
		return transactionService.getTransaction(id);
	}

	@PostMapping("/")
	public String addTransaction(@RequestBody Transaction transaction) {
		transactionService.addTransaction(transaction);
		return "transaction added successfully";
	}

	@PutMapping("/")
	public Transaction updatetransaction(@RequestBody Transaction transaction) {
		return transactionService.updateTransaction(transaction);
	}

	@DeleteMapping("/")
	public String removeTransaction(long id) {
		transactionService.removeTransaction(id);
		return "transaction deleted Successfully";
	}
}