package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ResultEntity;

public interface ResultRepo extends JpaRepository<ResultEntity, Integer> {

}