package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ExamEntity;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.StaffEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StaffService;
@RestController
@RequestMapping("/staff")
public class StaffController {
	
	
	
	@Autowired
	StaffService service;
	
	@GetMapping("/")
	public List<StaffEntity> showStaff(StaffEntity staff) {
		return service.details();
	}
	
	//Point 2- Adding student by staff 
		@GetMapping("/student")
		public List<StudentEntity> showStudent(@RequestBody StudentEntity stu) {
			return service.showStudent();
		}
		@PostMapping("/student")
		public List<StudentEntity> addStudent(@RequestBody StudentEntity stu) {
			return service.addStudent(stu);
		}
		
		
	//Point 5- Adding exam (questions and exam details)
	@GetMapping("/exam")
	public List<ExamEntity> showExam(@RequestBody ExamEntity ex) {
		return service.showExam();
	}
	@PostMapping("/exam")
	public List<ExamEntity> addExam(@RequestBody ExamEntity ex) {
		return service.addExam(ex);
	}
	
	
	//Point 11- List of student by name
		@GetMapping("/studentbyname")
		public List<String> findName(StudentEntity stu) {
			return service.findName();
		}
	
	
	
	//Adding result
	@GetMapping("/result")
	public List<ResultEntity> showResult(@RequestBody ResultEntity re) {
		return service.showResult();
	}
	@PostMapping("/result")
	public List<ResultEntity> addResult(@RequestBody ResultEntity re) {
		return service.addResult(re);
	}

	


}
