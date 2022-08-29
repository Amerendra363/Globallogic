package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ExamEntity;
import com.example.demo.entity.SubjectEntity;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping("/subject")
	public List<SubjectEntity> showSubject(SubjectEntity ex) {
		return service.showSubject();
	}
	
	
	@GetMapping("/exam")
	public List<ExamEntity> showExam(ExamEntity ex) {
		return service.showExam();
	}
}
