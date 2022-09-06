package com.globallogic.creditcardpayment.servicesImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.CreditCard;
import com.globallogic.creditcardpayment.repositories.CreditCardRepo;
import com.globallogic.creditcardpayment.services.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	
		
@Autowired
CreditCardRepo creditcardrepo;

		@Override
		public List<CreditCard> getAllCreditCard() {
		
			return creditcardrepo.findAll();
		}

		@Override
		public void addCreditCard(CreditCard creditcard) {
			
			creditcardrepo.save(creditcard);
		}

		@Override
		public CreditCard updateCreditCard(CreditCard creditcard) {
		
			return creditcardrepo.save(creditcard);
		}

		@Override
		public void removeCreditCard(long id) {
		
		
			creditcardrepo.deleteById(id);;
			
		}

		@Override
		public CreditCard getCreditCard(long id) {
			
			return creditcardrepo.findById(id).get();
			
		}

	}