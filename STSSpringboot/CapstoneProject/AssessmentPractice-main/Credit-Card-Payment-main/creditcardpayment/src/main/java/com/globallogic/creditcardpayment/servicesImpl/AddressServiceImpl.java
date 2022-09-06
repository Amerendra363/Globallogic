package com.globallogic.creditcardpayment.servicesImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Address;
import com.globallogic.creditcardpayment.repositories.AddressRepo;
import com.globallogic.creditcardpayment.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepo addressrepo;
	
	
	public Address saveaddress(Address address) {
		return addressrepo.save(address);
	}

	
	public List<Address> fetchAllAddress() {
		return addressrepo.findAll();
	}

	
	public Optional<Address> fetchAddressById(Long addressid) {
		return addressrepo.findById(addressid);
	}

	
	public Address updateAddress(Long addressid, Address address) {
		
		Address addressDB 
		= addressrepo.findById(addressid)
		             .get();
		
		if(Objects.nonNull(address.getDoorNo())
				&& !"".equalsIgnoreCase(
						address.getDoorNo())){
			addressDB.setDoorNo(
					address.getDoorNo());
		}
		
		if(Objects.nonNull(address.getStreet())
				&& !"".equalsIgnoreCase(
						address.getStreet())){
			addressDB.setStreet(
					address.getStreet());
		}
		
		if(Objects.nonNull(address.getArea())
				&& !"".equalsIgnoreCase(
						address.getArea())){
			addressDB.setArea(
					address.getArea());
		}
		
	
		if(Objects.nonNull(address.getCity())
				&& !"".equalsIgnoreCase(
						address.getCity())){
			addressDB.setCity(
					address.getCity());
		}
		
		if(Objects.nonNull(address.getState())
				&& !"".equalsIgnoreCase(
						address.getState())){
			addressDB.setState(
					address.getState());
		}
		
		
		return addressrepo.save(addressDB);
	}



	@Override
	public String deleteAddressByid(long addressid) {
		addressrepo.deleteById(addressid);
		return "Deleted succesfully";
		
	}

}