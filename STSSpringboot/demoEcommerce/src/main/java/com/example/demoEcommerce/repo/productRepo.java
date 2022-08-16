package com.example.demoEcommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoEcommerce.entity.ProductEntity;

public interface productRepo extends JpaRepository<ProductEntity, Integer> {

}
