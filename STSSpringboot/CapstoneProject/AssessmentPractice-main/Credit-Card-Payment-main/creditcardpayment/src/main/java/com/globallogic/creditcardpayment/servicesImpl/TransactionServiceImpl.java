package com.globallogic.creditcardpayment.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Statement;
import com.globallogic.creditcardpayment.entity.Transaction;
import com.globallogic.creditcardpayment.repositories.TransactionRepo;
import com.globallogic.creditcardpayment.services.Transcationservice;

@Service
public class TransactionServiceImpl implements Transcationservice {	
@Autowired
TransactionRepo transactionrepo;


		@Override
		public List<Transaction> getAllTransaction() {
		
			return transactionrepo.findAll();
		}

		@Override
		public void addTransaction(Transaction transaction) {
			
			transactionrepo.save(transaction);
		}

		@Override
		public Transaction updateTransaction(Transaction transaction) {
		
			return transactionrepo.save(transaction);
		}
		@Override
		public void removeTransaction(long id) {
		
		
			transactionrepo.deleteById(id);;
			
		}
		@Override
		public Transaction getTransaction(long id) {
			
			return transactionrepo.findById(id).get();
			
		}

	
	
}
