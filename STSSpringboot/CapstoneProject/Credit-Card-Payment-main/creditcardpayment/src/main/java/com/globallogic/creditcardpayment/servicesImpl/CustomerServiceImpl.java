package com.globallogic.creditcardpayment.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Address;
import com.globallogic.creditcardpayment.entity.CreditCard;
import com.globallogic.creditcardpayment.entity.Customer;
import com.globallogic.creditcardpayment.exception.EmptyInputException;
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
		List<Address> address = customer.getAddress();
		if (customer.getName().isEmpty() || customer.getEmail().isEmpty() || customer.getDateOfBirth() == null
				|| customer.getPhoneNo() == 0 || customer.getAccount() == null || customer.getCreditCard() == null
				|| customer.getAddress() == null || customer.getAccount().getAccountName().isEmpty()
				|| customer.getAccount().getAccountType().isEmpty() || customer.getAccount().getBalance() == 0
				|| customer.getCreditCard().getBankName().isEmpty() || customer.getCreditCard().getCardName().isEmpty()
				|| customer.getCreditCard().getCardNumber().isEmpty()
				|| customer.getCreditCard().getCardType().isEmpty() || customer.getCreditCard().getExpiryDate() == null
				|| customer.getUser().getPassword().isEmpty() || customer.getUser().getUserId().isEmpty()) {
			throw new EmptyInputException("601", "Input Fields are empty");
		}
		for (Address ad : address) {
			if (ad.getArea().isEmpty() || ad.getCity().isEmpty() || ad.getDoorNo().isEmpty() || ad.getPincode() == 0
					|| ad.getState().isEmpty() || ad.getStreet().isEmpty()) {
				throw new EmptyInputException("601", "Input Fields are empty");

			}
		}
		customerRepo.save(customer);
		return customerRepo.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		List<Address> address1 = customer.getAddress();
		if (customer.getName().isEmpty() || customer.getEmail().isEmpty() || customer.getDateOfBirth() == null
				|| customer.getPhoneNo() == 0 || customer.getAccount() == null || customer.getCreditCard() == null
				|| customer.getAddress() == null || customer.getAccount().getAccountName().isEmpty()
				|| customer.getAccount().getAccountType().isEmpty() || customer.getAccount().getBalance() == 0
				|| customer.getCreditCard().getBankName().isEmpty() || customer.getCreditCard().getCardName().isEmpty()
				|| customer.getCreditCard().getCardNumber().isEmpty()
				|| customer.getCreditCard().getCardType().isEmpty() || customer.getCreditCard().getExpiryDate() == null
				|| customer.getUser().getPassword().isEmpty() || customer.getUser().getUserId().isEmpty()) {
			throw new EmptyInputException("601", "Input Fields are empty");
		}
		for (Address ad : address1) {
			if (ad.getArea().isEmpty() || ad.getCity().isEmpty() || ad.getDoorNo().isEmpty() || ad.getPincode() == 0
					|| ad.getState().isEmpty() || ad.getStreet().isEmpty()) {
				throw new EmptyInputException("601", "Input Fields are empty");

			}
		}

		customerRepo.save(customer);

		userRepo.save(customer.getUser());

		List<Address> address = customer.getAddress();
		for (Address ad : address) {
			addressRepo.save(ad);
		}

		accountRepo.save(customer.getAccount());

		creditCardRepo.save(customer.getCreditCard());

		CreditCard card = creditCardRepo.findById(customer.getId()).get();

		transactionRepo.setCardNumberForTransaction(card.getCardNumber(), customer.getId());

		return customer;
	}

	@Override
	public String deleteCustomer(long id) {

		System.out.println("customer deleted successfully " + customerRepo.findById(id).get());
		Customer customer = customerRepo.findById(id).get();
		System.out.println(customer);
		System.out.println();

		System.out.println("customer deleted suuccessfully2 " + customerRepo.findById(id).get());
		customerRepo.deleteById(id);
		System.out.println();

		System.out.println("user deleted successfully " + userRepo.findById(customer.getUser().getId()).get());
		userRepo.deleteById(customer.getUser().getId());
		System.out.println();

		System.out.println(
				"account deleted successfully " + accountRepo.findById(customer.getAccount().getAccountid()).get());
		accountRepo.deleteById(customer.getAccount().getAccountid());
		System.out.println();

		System.out.println(
				"creditcard deleted successfully " + creditCardRepo.findById(customer.getCreditCard().getId()).get());
		creditCardRepo.deleteById(customer.getCreditCard().getId());
		System.out.println();

		List<Address> address = customer.getAddress();
		for (Address ad : address) {
			System.out.println("address deleted suuccessfully " + addressRepo.findById(ad.getAddressid()).get());
			addressRepo.deleteById(ad.getAddressid());
			System.out.println();
		}

		return "CUSTOMERS DETAILS DELETED SUCCESSFULLY";
	}

}
