package com.demo.demoJpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demoJpa.entity.DeptEntity;

public interface DeptRepo extends JpaRepository<DeptEntity, Integer>{

}
