package com.globallogic.creditcardpayment.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Payment;
import com.globallogic.creditcardpayment.repositories.PaymentRepo;
import com.globallogic.creditcardpayment.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentRepo prepo;

	@Override
	public void addPayment(Payment payment) {
		// TODO Auto-generated method stub
		prepo.save(payment);
		
	}

	@Override
	public Payment updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		return prepo.save(payment);
	}

	@Override
	public void removePayment(long id) {
		// TODO Auto-generated method stub
		prepo.deleteById(id);
		
	}

	@Override
	public Payment getPayment(long id) {
		// TODO Auto-generated method stub
		return prepo.findById(id).get();
	}

	@Override
	public List<Payment> getPayment() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

}
