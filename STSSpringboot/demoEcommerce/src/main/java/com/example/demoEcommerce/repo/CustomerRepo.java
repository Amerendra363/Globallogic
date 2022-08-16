package com.example.demoEcommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoEcommerce.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

}
