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

import com.globallogic.creditcardpayment.entity.CreditCard;
import com.globallogic.creditcardpayment.services.CreditCardService;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {
	@Autowired
	CreditCardService creditcardservice;

	@GetMapping("/")
	public List<CreditCard> getCreditCard() {
		return creditcardservice.getAllCreditCard();
	}

	@GetMapping("/{id}")
	public CreditCard getCreditCard(@PathVariable("id") long id) {
		return creditcardservice.getCreditCard(id);

	}

	@PostMapping("/")
	public String addCreditCard(@RequestBody CreditCard creditcard) {
		creditcardservice.addCreditCard(creditcard);
		return "Credit Card added successfully";
	}

	@PutMapping("/")
	public CreditCard updateCreditCard(@RequestBody CreditCard creditcard) {
		return creditcardservice.updateCreditCard(creditcard);
	}

	@DeleteMapping("/")
	public String removeCreditCard(long id) {
		creditcardservice.removeCreditCard(id);
		return "Credit card deleted Successfully";
	}

}