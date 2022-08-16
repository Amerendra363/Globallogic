package com.example.demoEcommerce.controller;

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

import com.example.demoEcommerce.entity.CategoryEntity;
import com.example.demoEcommerce.repo.CategoryRepo;
import com.example.demoEcommerce.repo.CustomerRepo;
import com.example.demoEcommerce.repo.MerchantRepo;
import com.example.demoEcommerce.repo.productRepo;

@RestController
@RequestMapping("/category")
public class HomeController {
	
	@Autowired
	CategoryRepo CaRepo;
	@Autowired
	CustomerRepo CuRepo;
	@Autowired
	MerchantRepo MRepo;
	@Autowired
	productRepo pRepo;
	
	
	@GetMapping("/")
	public List<CategoryEntity> showCategory()
	{
		return CaRepo.findAll();
	}
	
	
	@PostMapping("/")
	public List<CategoryEntity> saveCategory(@RequestBody CategoryEntity categoryEntity){
		CaRepo.save(categoryEntity);
		return CaRepo.findAll();
	}
	@PutMapping("/")
	public List<CategoryEntity> updateCategory(@RequestBody CategoryEntity categoryEntity){
		CaRepo.save(categoryEntity);
		return CaRepo.findAll();
	}
	@DeleteMapping("/{id}")
	public List<CategoryEntity> deleteDept(@PathVariable("id") int id){
		CaRepo.deleteById(id);
		return CaRepo.findAll();
	}

}
