package com.globallogic.EmployeeServices.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.EmployeeServices.entity.EmployeeEntity;

@Repository
public interface EmployeeRepo  extends JpaRepository<EmployeeEntity, Long>{

}