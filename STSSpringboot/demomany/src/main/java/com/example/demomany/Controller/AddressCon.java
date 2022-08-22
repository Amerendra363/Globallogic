package com.example.demomany.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demomany.Entity.Address;
import com.example.demomany.Repo.AddressRepo;


@RestController
@RequestMapping("/address")
public class AddressCon {
	
	@Autowired
	AddressRepo repo;
	
	
	@GetMapping("/")
	public List<Address> showDetails() {
		
		return repo.findAll();
	}

	@PostMapping("/")
	public List<Address> addAddress(@RequestBody Address add) {
		
		repo.save(add);
		System.out.println("Data Added Successfully");
		return repo.findAll();
				
		
	}
	
	@PutMapping("/")
	public List<Address> updateAddress(@RequestBody Address add) {
		repo.save(add);
		System.out.println("Data updated Successfully");
		return repo.findAll();
		
	}
	
	@DeleteMapping("/{id}")
	public List<Address> deleteAddress(@PathVariable("id") long id) {
		
		System.err.println("Deleted id is "+id);
		repo.deleteById(id);
		return repo.findAll();
	}
	
	
	
	
}