package com.globallogic.creditcardpayment.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Account;
import com.globallogic.creditcardpayment.entity.Address;
import com.globallogic.creditcardpayment.entity.CreditCard;
import com.globallogic.creditcardpayment.entity.Customer;
import com.globallogic.creditcardpayment.entity.Statement;
import com.globallogic.creditcardpayment.entity.Transaction;
import com.globallogic.creditcardpayment.entity.User;
import com.globallogic.creditcardpayment.repositories.AccountRepo;
import com.globallogic.creditcardpayment.repositories.AddressRepo;
import com.globallogic.creditcardpayment.repositories.CreditCardRepo;
import com.globallogic.creditcardpayment.repositories.CustomerRepo;
import com.globallogic.creditcardpayment.repositories.StatementRepo;
import com.globallogic.creditcardpayment.repositories.TransactionRepo;
import com.globallogic.creditcardpayment.repositories.UserRepo;
import com.globallogic.creditcardpayment.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	AddressRepo addressRepo;

	@Autowired
	AccountRepo accountRepo;

	@Autowired
	CreditCardRepo creditCardRepo;

	@Autowired
	StatementRepo statementRepo;

	@Autowired
	TransactionRepo transactionRepo;

	@Override
	public List<Customer> showCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public Customer showCustomerById(long custId) {
		return customerRepo.findById(custId).get();
	}
	
	@Override
	public List<Customer> addCustomer(Customer customer) {
		customerRepo.save(customer);
		return customerRepo.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		customerRepo.save(customer);

		userRepo.save(customer.getUser());

		List<Address> address = customer.getAddress();
		for (Address ad : address) {
			addressRepo.save(ad);
		}

		accountRepo.save(customer.getAccount());

		creditCardRepo.save(customer.getCreditCard());
		
		CreditCard card = creditCardRepo.findById(customer.getId()).get();
		
		transactionRepo.setCardNumberForTransaction(card.getCardNumber(),customer.getId());


		return customer;
	}

	@Override
	public String deleteCustomer(long id) {

		System.out.println("customer deleted successfully "+customerRepo.findById(id).get());
		Customer customer = customerRepo.findById(id).get();
		System.out.println(customer);
		System.out.println();
		
		System.out.println("customer deleted suuccessfully2 "+customerRepo.findById(id).get());
		customerRepo.deleteById(id);
		System.out.println();
		
		System.out.println("user deleted successfully "+userRepo.findById(customer.getUser().getId()).get());
		userRepo.deleteById(customer.getUser().getId());
		System.out.println();
		
		System.out.println("account deleted successfully "+accountRepo.findById(customer.getAccount().getAccountid()).get());
		accountRepo.deleteById(customer.getAccount().getAccountid());
		System.out.println();
		
		System.out.println("creditcard deleted successfully "+creditCardRepo.findById(customer.getCreditCard().getId()).get());
		creditCardRepo.deleteById(customer.getCreditCard().getId());
		System.out.println();

		List<Address> address = customer.getAddress();
		for (Address ad : address) {
			System.out.println("address deleted successfully "+addressRepo.findById(ad.getAddressid()).get());
			addressRepo.deleteById(ad.getAddressid());
			System.out.println();
		}
		
		return "CUSTOMERS DETAILS DELETED SUCCESSFULLY";
	}

	@Override
	public List<Customer> addCustomer2(Customer customer) {
		
		User user = userRepo.findById(customer.getUser().getId()).get();
		customer.setUser(user);
		
		Account account = accountRepo.findById(customer.getAccount().getAccountid()).get();
		customer.setAccount(account);
		
		CreditCard creditCard = creditCardRepo.findById(customer.getCreditCard().getId()).get();
		customer.setCreditCard(creditCard);
		
		List<Address> address = customer.getAddress();
		List<Address> addressList = new ArrayList<>();
		for(Address ad : address){
			Address ad1 = addressRepo.findById(ad.getAddressid()).get();
			addressList.add(ad1);
		}
		customer.setAddress(addressList);
		customerRepo.save(customer);
		return customerRepo.findAll();
	}

	

}
