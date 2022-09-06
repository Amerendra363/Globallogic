package com.globallogic.creditcardpayment.services;

import java.util.List;

import com.globallogic.creditcardpayment.entity.Payment;



public interface PaymentService {

	
	public void addPayment( Payment payment);
    

	public Payment updatePayment(Payment payment);

	
	public void removePayment(long id);
	
      public Payment getPayment(long id);
      public List<Payment> getPayment();
}
