package com.globallogic.creditcardpayment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Transaction;
@Service
public interface Transcationservice {
	
	
		public List<Transaction> getAllTransaction();

		public void addTransaction(Transaction Transaction);

		public Transaction updateTransaction(Transaction Transaction);

		public void removeTransaction(long id);

		public Transaction getTransaction(long id);

	}