package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StaffEntity;

public interface StaffRepo extends JpaRepository<StaffEntity, Integer> {

}
