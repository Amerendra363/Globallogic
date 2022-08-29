package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.ExamEntity;
import com.example.demo.entity.ResultEntity;
import com.example.demo.entity.StaffEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.SubjectEntity;

@Service
@Component
public interface AdminService {
	public List<AdminEntity> details();
	public List<AdminEntity> addAdmin(AdminEntity ad);
	
	public List<SubjectEntity> showSubject();
	public  List<SubjectEntity> addSubject(SubjectEntity sta);
	
	public List<StaffEntity> showStaff();
	public  List<StaffEntity> addStaff(StaffEntity sta);
	
	public List<StudentEntity> showStudent();
	public List<String> findName();
	public List<StudentEntity> addStudent(StudentEntity stu);
	
	
	
	public List<ExamEntity> showExam();
	public List<ExamEntity> addExam(ExamEntity e);

	
	
	public List<ResultEntity> showResult();
	public List<ResultEntity> addResult(ResultEntity e);

}
