package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
	@Query("Select Sname from StudentEntity")
	public List<String> findName();

}