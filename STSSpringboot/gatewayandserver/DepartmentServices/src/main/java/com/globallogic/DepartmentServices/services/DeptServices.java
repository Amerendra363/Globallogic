package com.globallogic.DepartmentServices.services;



import java.util.List;

import org.springframework.stereotype.Service;

import com.globallogic.DepartmentServices.entity.DeptEntity;

@Service
public interface DeptServices {
	

	public List<DeptEntity> getDept();

	
	public void addDept( DeptEntity dept);
    

	public DeptEntity updateDept(DeptEntity dept);

	
	public void deleteDepartment(long id);

}