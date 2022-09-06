package com.globallogic.creditcardpayment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.creditcardpayment.entity.Address;
import com.globallogic.creditcardpayment.services.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/addAddress")
	public Address saveaddress(@RequestBody Address address) {
		return addressService.saveaddress(address);
	}
	
	@GetMapping("/address")
	public List<Address> fetchAllAddress(){
		return addressService.fetchAllAddress();
	}
	
	@GetMapping("/address/{addressid}")
	public Optional<Address> fetchAddressById(@PathVariable("addressid") Long addressid){
		return addressService.fetchAddressById(addressid);
	}
	
	@PutMapping("/address/{addressid}")
	public String updateAddress(@PathVariable("addressid") Long addressid , @RequestBody Address address) {
		 addressService.updateAddress(addressid, address);
		 return "Address updated successfully";
	}
	
	@DeleteMapping("/address/{addressid}")
	public String deleteAddressByid(@PathVariable("addressid") Long addressid){
		addressService.deleteAddressByid(addressid);
		return "Address deleted succesfully";
	}
	
	
	

}