package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ExamEntity;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.SubjectEntity;

@Service
@Component
public interface StudentService {
	public List<SubjectEntity> showSubject();
	public List<ExamEntity> showExam();
	public List<ResultEntity> showResult();

}
