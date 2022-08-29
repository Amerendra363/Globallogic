package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ExamEntity;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.StaffEntity;
import com.example.demo.entity.StudentEntity;

@Service
@Component
public interface StaffService {
	public List<StaffEntity> details();
	
	public List<StudentEntity> showStudent();
	public List<String> findName();
	public List<StudentEntity> addStudent(StudentEntity stu);
	
	public List<ExamEntity> showExam();
	public List<ExamEntity> addExam(ExamEntity e);
	
	public List<ResultEntity> showResult();
	public List<ResultEntity> addResult(ResultEntity e);

}
