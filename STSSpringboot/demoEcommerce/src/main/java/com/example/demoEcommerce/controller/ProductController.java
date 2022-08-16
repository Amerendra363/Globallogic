package com.example.demoEcommerce.controller;

import java.util.ArrayList;
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

import com.example.demoEcommerce.entity.ProductEntity;
import com.example.demoEcommerce.repo.CategoryRepo;
import com.example.demoEcommerce.repo.CustomerRepo;
import com.example.demoEcommerce.repo.MerchantRepo;
import com.example.demoEcommerce.repo.productRepo;

@RestController
@RequestMapping("/ecommerce")
public class ProductController {
	
	@Autowired
	CategoryRepo CaRepo;
	@Autowired
	CustomerRepo CuRepo;
	@Autowired
	MerchantRepo MRepo;
	@Autowired
	productRepo pRepo;
	
	@GetMapping("/")
	public List<ProductEntity> showProduct()
	{
		return pRepo.findAll();
	}
	
	
	@GetMapping("/prod/{name}")
	public List<String> showProductByCategoryName(@PathVariable("name") String cName){
		
		List<ProductEntity> prod = pRepo.findAll();
		System.out.println(prod);
		
		List<ProductEntity> prodName = prod.stream().filter(e -> (e.getCaEn().getCat()).equalsIgnoreCase(cName)).collect(Collectors.toList());
		
		System.out.println(prodName);
		List<String> name = new ArrayList<>();
		for(ProductEntity pro : prodName ) {
			name.add(pro.getName());
		}
		return name;	
	}
	
	
//	@GetMapping("/")
//	public List<ProductEntity> showProductByCat()
//	{
//		return pRepo.findAll();
//	}
	
	
	@PostMapping("/")
	public ProductEntity saveProduct(@RequestBody ProductEntity pr) {
//		System.out.println("PRODUCT "+pr.get());
//		DeptEntity entity=deptRepo.findById(emp.getDept().getId()).get();
//		System.err.println(entity);
//		emp.setDept(entity);
//		System.err.println(emp);
		pRepo.save(pr);
		System.err.println(pr);
		return pr;
	}
	
	@PutMapping("/")
	public ProductEntity updateProduct(@RequestBody ProductEntity pr) {
		System.out.println(pr);
		pRepo.save(pr);
		System.out.println(pr);
		return pr;
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		System.err.println("Deleted");
		pRepo.deleteById(id);
		
		return "Record has been deleted";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
