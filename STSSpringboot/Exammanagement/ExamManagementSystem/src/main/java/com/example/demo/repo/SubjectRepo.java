package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SubjectEntity;

public interface SubjectRepo extends JpaRepository<SubjectEntity, Integer> {

}