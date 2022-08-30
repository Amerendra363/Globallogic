package com.example.demo.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.ExamEntity;

public interface ExamRepo extends JpaRepository<ExamEntity, Integer> {
	@Modifying
	@Transactional
	@Query("update ExamEntity e set estatus = :estatus where e.id = :id")
	public void setStatusForExam(String estatus, int id);

}