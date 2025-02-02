package com.globallogic.creditcardpayment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.creditcardpayment.entity.Customer;

@Repository
public interface CustomerRepo  extends JpaRepository<Customer, Long>{

	public Customer findByCreditCardId(long id);
	
	public Customer findByAccountAccountid(long id);
	
	//public Customer findByUserName(String id);
}