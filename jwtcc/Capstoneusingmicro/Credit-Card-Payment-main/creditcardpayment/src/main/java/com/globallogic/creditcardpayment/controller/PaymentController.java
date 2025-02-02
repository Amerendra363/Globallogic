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
import com.globallogic.creditcardpayment.entity.Payment;
import com.globallogic.creditcardpayment.services.PaymentService;
import com.globallogic.creditcardpayment.services.PaymentService;

@RestController
@RequestMapping("/cc/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping("/")
	public List<Payment> showPayment() {
		return paymentService.showPayment();
	}
	
	@GetMapping("/{id}")
	public Payment showPaymentById(@PathVariable("id") long id) {
		return paymentService.showPaymentById(id);
	}

	@PostMapping("/")
	public List<Payment> addPayment(@RequestBody Payment payment) {
		return paymentService.addPayment(payment);
	}

	@PutMapping("/")
	public Payment updatePayment(@RequestBody Payment payment) {
		return paymentService.updatePayment(payment);
	}

	@DeleteMapping("/{id}")
	public String deletePayment(@PathVariable("id") long id) {
		return paymentService.deletePayment(id);
	}

}
