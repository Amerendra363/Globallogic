package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ExamEntity;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.StaffEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repo.ExamRepo;
import com.example.demo.repo.ResultRepo;
import com.example.demo.repo.StaffRepo;
import com.example.demo.repo.StudentRepo;
@Component
@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	StaffRepo staffRepo;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	ExamRepo examRepo;
	@Autowired
	ResultRepo resultRepo;
	
	@Override
	public List<StaffEntity> details() {
		return staffRepo.findAll();
	}

	

	public List<StudentEntity> showStudent() {
		return studentRepo.findAll();
	}
	public List<String> findName() {
		return studentRepo.findName();
	}
	public List<StudentEntity> addStudent(StudentEntity stu) {
		studentRepo.save(stu);
		return studentRepo.findAll();
	}
	

	
	public List<ExamEntity> showExam() {
		return examRepo.findAll();
	}
	public List<ExamEntity> addExam(ExamEntity stu) {
		examRepo.save(stu);
		return examRepo.findAll();
	}
	
	public List<ResultEntity> showResult() {
		return resultRepo.findAll();
	}
	public List<ResultEntity> addResult(ResultEntity sta) {
		resultRepo.save(sta);
		return resultRepo.findAll();
	}

}
