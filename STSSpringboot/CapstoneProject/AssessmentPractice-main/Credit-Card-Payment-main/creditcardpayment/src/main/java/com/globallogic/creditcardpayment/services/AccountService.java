package com.globallogic.creditcardpayment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Account;



@Service
public interface AccountService {
public List<Account> getAllAccount();

	
	public void addAccount( Account account);
    

	public Account updateAccount(Account account);

	
	public void removeAccount(long id);
	
      public Account getAccount(long id);
}
	
	


