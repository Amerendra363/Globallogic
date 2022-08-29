package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.ExamEntity;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.StaffEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.SubjectEntity;
import com.example.demo.repo.AdminRepo;
import com.example.demo.repo.ExamRepo;
import com.example.demo.repo.ResultRepo;
import com.example.demo.repo.StaffRepo;
import com.example.demo.repo.StudentRepo;
import com.example.demo.repo.SubjectRepo;
@Component
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepo adminRepo;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	ExamRepo examRepo;
	@Autowired
	StaffRepo staffRepo;
	@Autowired
	ResultRepo resultRepo;
	@Autowired
	SubjectRepo subjectRepo;

	
	@Override
	public List<AdminEntity> details() {
		return adminRepo.findAll();
	}
	public List<AdminEntity> addAdmin(AdminEntity ad) {
		adminRepo.save(ad);
		return adminRepo.findAll();
	}
	
	
	@Override
	public List<SubjectEntity> showSubject() {
		return subjectRepo.findAll();
	}
	public List<SubjectEntity> addSubject(SubjectEntity stu) {
		subjectRepo.save(stu);
		return subjectRepo.findAll();
	}
	
	@Override
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
	
	
	@Override
	public List<ExamEntity> showExam() {
		return examRepo.findAll();
	}
	public List<ExamEntity> addExam(ExamEntity stu) {
		examRepo.save(stu);
		return examRepo.findAll();
	}
	
	
	@Override
	public List<StaffEntity> showStaff() {
		return staffRepo.findAll();
	}
	public List<StaffEntity> addStaff(StaffEntity sta) {
		staffRepo.save(sta);
		return staffRepo.findAll();
	}
	
	
	@Override
	public List<ResultEntity> showResult() {
		return resultRepo.findAll();
	}
	public List<ResultEntity> addResult(ResultEntity sta) {
		resultRepo.save(sta);
		return resultRepo.findAll();
	}
	
}
