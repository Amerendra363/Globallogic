package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ExamEntity;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.SubjectEntity;
import com.example.demo.repo.ExamRepo;
import com.example.demo.repo.ResultRepo;
import com.example.demo.repo.SubjectRepo;

@Component
public class StudentServiceImpl implements StudentService{
	@Autowired
	SubjectRepo subjectRepo;
	@Autowired
	ExamRepo examRepo;
	@Autowired
	ResultRepo resultRepo;

	public List<SubjectEntity> showSubject() {
		return subjectRepo.findAll();
	}
	@Override
	public List<ExamEntity> showExam() {
		return examRepo.findAll();
	}
	public List<ResultEntity> showResult() {
		return resultRepo.findAll();
	}

}
