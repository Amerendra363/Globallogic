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
import com.globallogic.creditcardpayment.entity.CreditCard;
import com.globallogic.creditcardpayment.services.CreditCardService;

@RestController
@RequestMapping("/cc/creditCard")
public class CreditCardController {

	@Autowired
	CreditCardService creditCardService;

	@GetMapping("/showCreditCard")
	public List<CreditCard> showCreditCard() {
		return creditCardService.showCreditCard();
	}

	@GetMapping("/showCreditCardById/{cardId}")
	public CreditCard showCreditCardById(@PathVariable("cardId") long cardId) {
		return creditCardService.showCreditCardById(cardId);
	}

	@PostMapping("/addCreditCard")
	public String addCreditCard(@RequestBody CreditCard creditCard) {
		return creditCardService.addCreditCard(creditCard);
	}

	@PutMapping("/updateCreditCard")
	public String updateCreditCard(@RequestBody CreditCard creditCard) {
		return creditCardService.updateCreditCard(creditCard);
	}

	@DeleteMapping("/deleteCreditCardById/{id}")
	public String deleteCreditCard(@PathVariable("id") long id) {
		return creditCardService.deleteCreditCard(id);
	}

}
