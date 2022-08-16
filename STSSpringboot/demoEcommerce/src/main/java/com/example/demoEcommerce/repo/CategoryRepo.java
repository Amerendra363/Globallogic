package com.example.demoEcommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoEcommerce.entity.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {

}
