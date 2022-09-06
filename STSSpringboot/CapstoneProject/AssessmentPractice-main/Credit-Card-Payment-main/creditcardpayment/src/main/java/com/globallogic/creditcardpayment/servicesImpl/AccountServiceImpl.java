package com.globallogic.creditcardpayment.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Account;
import com.globallogic.creditcardpayment.repositories.AccountRepo;
import com.globallogic.creditcardpayment.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepo acrepo;

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return acrepo.findAll();
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		acrepo.save(account);
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return acrepo.save(account);
	}

	@Override
	public void removeAccount(long id) {
		// TODO Auto-generated method stub
	
		 acrepo.deleteById(id);;
		
	}

	@Override
	public Account getAccount(long id) {
		// TODO Auto-generated method stub
		return acrepo.findById(id).get();
		
	}

}
