package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ExamEntity;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.SubjectEntity;
import com.example.demo.service.ExamService;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	ExamService eservice;
	@Autowired
	StudentService service;
	// point 6 - view all subject
	@GetMapping("/subject")
	public List<SubjectEntity> showSubject(SubjectEntity ex) {
		return service.showSubject();
	}
	
	//Point 7- view all exam
	@GetMapping("/exam")
	public List<ExamEntity> showExam(ExamEntity ex) {
		return service.showExam();
	}
	
	
	
	//Point 8- Attempt exam
	@GetMapping("/examstatus/{id}")
	public String attemptExam(@PathVariable int ex) {
		return eservice.attemptExam(ex);
	}
	
	@GetMapping("/result")
	public List<ResultEntity> showResult( ResultEntity re) {
		return service.showResult();
	}
}
