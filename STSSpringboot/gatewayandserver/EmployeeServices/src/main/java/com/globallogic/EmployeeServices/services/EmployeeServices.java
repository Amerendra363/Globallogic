package com.globallogic.EmployeeServices.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.globallogic.EmployeeServices.entity.EmployeeEntity;

@Service
public interface EmployeeServices {
	

	abstract public List<EmployeeEntity> getEmployee(); 

	
	abstract public void addEmployee(EmployeeEntity emp);
    

	abstract public void updateEmployee(EmployeeEntity emp);

	
	abstract public void deleteEmployee(long id);

}