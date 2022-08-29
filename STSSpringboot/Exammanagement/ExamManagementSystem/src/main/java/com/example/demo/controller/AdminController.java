package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.ExamEntity;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.StaffEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.SubjectEntity;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService service;

	// Adding admin
	@GetMapping("/")
	public List<AdminEntity> showAdmin(AdminEntity admin) {
		return service.details();
	}

	@PostMapping("/")
	public List<AdminEntity> addAdmin(@RequestBody AdminEntity ad) {
		return service.addAdmin(ad);
	}
	
	
	
	//Adding subject
	@GetMapping("/subject")
	public List<SubjectEntity> showSubject(SubjectEntity ex) {
		return service.showSubject();
	}
	@PostMapping("/subject")
	public List<SubjectEntity> addSubject(@RequestBody SubjectEntity ex) {
		return service.addSubject(ex);
	}

	// Point 1&4&5 -adding exam(cousre, subject, Stream)
	@GetMapping("/exam")
	public List<ExamEntity> showExam(ExamEntity ex) {
		return service.showExam();
	}
	@PostMapping("/exam")
	public List<ExamEntity> addExam(@RequestBody ExamEntity ex) {
		return service.addExam(ex);
	}

	// Point 2- Adding student by admin
	@GetMapping("/student")
	public List<StudentEntity> showStudent( StudentEntity stu) {
		return service.showStudent();
	}
	
	@PostMapping("/student")
	public List<StudentEntity> addStudent(@RequestBody StudentEntity stu) {
		return service.addStudent(stu);
	}

	// Point 3- Adding Staff by admin
	@GetMapping("/staff")
	public List<StaffEntity> showStaff( StaffEntity sta) {
		return service.showStaff();
	}
	@PostMapping("/staff")
	public List<StaffEntity> addStaff(@RequestBody StaffEntity sta) {
		return service.addStaff(sta);
	}
	//Point 11- List of student by name
	@GetMapping("/studentbyname")
	public List<String> findName(StudentEntity stu) {
		return service.findName();
	}

	// adding result
	@GetMapping("/result")
	public List<ResultEntity> showResult( ResultEntity re) {
		return service.showResult();
	}
	@PostMapping("/result")
	public List<ResultEntity> addResult(@RequestBody ResultEntity re) {
		return service.addResult(re);
	}

}
