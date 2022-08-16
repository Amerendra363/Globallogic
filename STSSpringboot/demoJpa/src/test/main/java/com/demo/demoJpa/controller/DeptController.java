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
import com.demo.demoJpa.repo.DeptRepo;

@RestController
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	DeptRepo deptRepo;
	@GetMapping("/")
	public List<DeptEntity> getDept(){
		return deptRepo.findAll();
	}
	
	@PostMapping("/")
	public List<DeptEntity> saveDept(@RequestBody DeptEntity deptEntity){
		deptRepo.save(deptEntity);
		return deptRepo.findAll();
	}
	@PutMapping("/")
	public List<DeptEntity> updateDept(@RequestBody DeptEntity deptEntity){
		deptRepo.save(deptEntity);
		return deptRepo.findAll();
	}
	@DeleteMapping("/{id}")
	public List<DeptEntity> deleteDept(@PathVariable("id") int id){
		deptRepo.deleteById(id);
		return deptRepo.findAll();
	}
	

}
