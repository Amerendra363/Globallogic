package com.example.demoEcommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoEcommerce.entity.MerchantEntity;
import com.example.demoEcommerce.entity.ProductEntity;
import com.example.demoEcommerce.repo.MerchantRepo;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
	@Autowired
	MerchantRepo MRepo;
	@GetMapping("/")
	public List<MerchantEntity> getDept(){
		return MRepo.findAll();
	}
	
	@PostMapping("/")
	public List<MerchantEntity> saveDept(@RequestBody MerchantEntity merchantEntity){
		MRepo.save(merchantEntity);
		return MRepo.findAll();
	}
	@PutMapping("/")
	public List<MerchantEntity> updateDept(@RequestBody MerchantEntity merchantEntity){
		MRepo.save(merchantEntity);
		return MRepo.findAll();
	}
	@DeleteMapping("/{id}")
	public List<MerchantEntity> deleteDept(@PathVariable("id") int id){
		MRepo.deleteById(id);
		return MRepo.findAll();
	}
	
	
	
}
