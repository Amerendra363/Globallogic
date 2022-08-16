package com.demo.demoJpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demoJpa.entity.EmployeeEntity;

public interface Employeerepo extends JpaRepository<EmployeeEntity, Integer> {

}
