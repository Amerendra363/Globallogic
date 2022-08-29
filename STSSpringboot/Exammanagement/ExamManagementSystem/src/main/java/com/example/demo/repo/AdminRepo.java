package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AdminEntity;

public interface AdminRepo extends JpaRepository<AdminEntity, Integer> {

}