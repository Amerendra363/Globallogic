package com.globallogic.creditcardpayment.services;
import java.util.List;


import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.CreditCard;



@Service

public interface CreditCardService {

	public List<CreditCard> getAllCreditCard();

	public void addCreditCard(CreditCard creditcard);

	public CreditCard updateCreditCard(CreditCard creditcard);

	public void removeCreditCard(long id);

	public CreditCard getCreditCard(long id);

}