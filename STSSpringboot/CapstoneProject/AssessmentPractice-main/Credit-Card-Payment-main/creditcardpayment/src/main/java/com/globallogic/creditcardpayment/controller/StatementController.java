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

import com.globallogic.creditcardpayment.entity.Statement;
import com.globallogic.creditcardpayment.services.StatementService;

@RestController
@RequestMapping("/statement")
public class StatementController {
	@Autowired
	StatementService statementService;

	@GetMapping("/")
	public List<Statement> getStatement() {
		return statementService.getAllStatement();
	}

	@GetMapping("/{id}")
	public Statement getStatement(@PathVariable("id") long id) {
		return statementService.getStatement(id);
	}

	@PostMapping("/")
	public String addStatement(@RequestBody Statement statement) {
		statementService.addStatement(statement);
		return "Statement added successfully";
	}

	@PutMapping("/")
	public Statement updateStatement(@RequestBody Statement statement) {
		return statementService.updateStatement(statement);
	}

	@DeleteMapping("/")
	public String removeStatement(long id) {
		statementService.removeStatement(id);
		return "Statement deleted Successfully";
	}
}
