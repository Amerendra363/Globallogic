package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ExamRepo;

@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	ExamRepo examRepo;
	@Override
	public String attemptExam(int id) {
		// TODO Auto-generated method stub
		examRepo.setStatusForExam("Active", id);
		return "Attempted";
	}
	

}
