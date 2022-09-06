package com.globallogic.creditcardpayment.services;

import java.util.List;
import java.util.Optional;

import com.globallogic.creditcardpayment.entity.Address;

public interface AddressService {
	
//	//save address(Post)
	public Address saveaddress(Address address);
	
	//get all address(Get)
	public List<Address> fetchAllAddress();
	
	//get address by id(Get)
	public Optional<Address> fetchAddressById(Long addressid);
	
	//update address(Put)
	public Address updateAddress(Long addressid , Address address);
	
	//delete address(Delete)
	
	public String deleteAddressByid(long addressid);
	
	
	
		

}