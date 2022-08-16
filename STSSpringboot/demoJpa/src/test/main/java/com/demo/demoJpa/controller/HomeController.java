package com.demo.demoJpa.controller;

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

import com.demo.demoJpa.entity.DeptEntity;
import com.demo.demoJpa.entity.EmployeeEntity;
import com.demo.demoJpa.repo.DeptRepo;
import com.demo.demoJpa.repo.Employeerepo;

@RestController
@RequestMapping("/employee")
public class HomeController {
	
	@Autowired
	Employeerepo repo;
	@Autowired
	DeptRepo deptRepo;
	
	@GetMapping("/")
	public List<EmployeeEntity> showEmployee()
	{
		return repo.findAll();
	}
	@PostMapping("/")
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity emp) {
		System.out.println("dept "+emp.getDept());
		DeptEntity entity=deptRepo.findById(emp.getDept().getId()).get();
		System.err.println(entity);
		emp.setDept(entity);
		System.err.println(emp);
		repo.save(emp);
		System.err.println(emp);
		return emp;
	}
	
	@PutMapping("/")
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity emp) {
		System.out.println(emp);
		repo.save(emp);
		System.out.println(emp);
		return emp;
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		System.err.println("Deleted");
		repo.deleteById(id);
		
		return "Record has been deleted";
	}

}
