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

import com.example.demomany.Entity.Register;
import com.example.demomany.Repo.RegisterRepo;



@RestController
@RequestMapping("/register")
public class ResgisterCon {
	
	@Autowired
	RegisterRepo repo;
	
	
	@GetMapping("/")
	public List<Register> showDetails() {
		
		return repo.findAll();
	}

	@PostMapping("/")
	public List<Register> addRegister(@RequestBody Register reg) {
		
		
		repo.save(reg);
		System.out.println("Data Added Successfully");
		return repo.findAll();
				
		
	}
	
	@PutMapping("/")
	public List<Register> updateRegister(@RequestBody Register reg) {
		repo.save(reg);
		System.out.println("Data updated Successfully");
		return repo.findAll();
		
	}
	
	@DeleteMapping("/{id}")
	public List<Register> deleteRegister(@PathVariable("id") long id) {
		
		System.err.println("Deleted id is "+id);
		repo.deleteById(id);
		return repo.findAll();
	}
	
	
	
	
}