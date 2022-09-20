package com.globallogic.DepartmentServices.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.DepartmentServices.entity.DeptEntity;
import com.globallogic.DepartmentServices.services.DeptServices;


@RestController
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	DeptServices deptServices; 
	
	@GetMapping("/")
	public List<DeptEntity> getDept() {
          return deptServices.getDept();
	}

	@PostMapping("/")
	public void addDept(@RequestBody DeptEntity dept) {
		deptServices.addDept(dept);
	}
    
	@PutMapping("/")
	public DeptEntity updateDept(@RequestBody DeptEntity dept) {
		return deptServices.updateDept(dept);
	}

	@DeleteMapping("/")
	public void deleteDepartment(long id) {
		deptServices.deleteDepartment(id);
	}
//	@GetMapping("/{id}")
//	public ResponseTemp getEmpwithDept(@PathVariable Long empId) {
//		return deptServices.getEmpwithDept(empId);
//	}
	
}