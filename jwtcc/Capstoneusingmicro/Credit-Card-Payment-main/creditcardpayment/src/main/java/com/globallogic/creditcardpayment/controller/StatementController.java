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

import com.globallogic.creditcardpayment.entity.Payment;
import com.globallogic.creditcardpayment.entity.Statement;
import com.globallogic.creditcardpayment.services.StatementService;

@RestController
@RequestMapping("/cc/statement")
public class StatementController {

	@Autowired
	StatementService statementService;

	@GetMapping("/")
	public List<Statement> showAllStatement() {
		return statementService.showAllStatement();
	}

	@GetMapping("/{id}")
	public Statement showStatement(@PathVariable("id") long id) {
		return statementService.showStatement(id);
	}

	@GetMapping("/billed/id/{custid}")
	public String showABilledStatementForCustomer(@PathVariable("custid") long custId) {
		return statementService.showBilledStatementForCustomer(custId);
	}

	//CUSTOMER ID TO GET STATEMENT
	@GetMapping("/unbilled/id/{custid}")
	public String showUnbilledStatementForCustomer(@PathVariable("custid") long custId) {
		return statementService.showUnbilledStatementForCustomer(custId);
	}

	@PostMapping("/")
	public String addStatement(@RequestBody Statement statement) {
		return statementService.addStatement(statement);
	}

	@PutMapping("/")
	public String updateStatement(@RequestBody Statement statement) {
		return statementService.updateStatement(statement);
	}

	@DeleteMapping("/{id}")
	public String deleteStatement(@PathVariable("id") long id) {
		return statementService.deleteStatement(id);
	}

}
