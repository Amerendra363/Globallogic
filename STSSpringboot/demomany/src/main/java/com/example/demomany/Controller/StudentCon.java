package com.example.demomany.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demomany.Entity.Address;
import com.example.demomany.Entity.Register;
import com.example.demomany.Entity.Student;
import com.example.demomany.Entity.Teacher;
import com.example.demomany.Repo.AddressRepo;
import com.example.demomany.Repo.RegisterRepo;
import com.example.demomany.Repo.StudentRepo;
import com.example.demomany.Repo.TeacherRepo;


@RestController
@RequestMapping("/student")
public class StudentCon {
	
	@Autowired
	StudentRepo repo;
	
	@Autowired
	AddressRepo addRepo;
	
	@Autowired
	RegisterRepo regRepo;
	
	@Autowired
	TeacherRepo teaRepo;
	
	
	@GetMapping("/")
	public List<Student> showDetails() {
		
		return repo.findAll();
	}

	@PostMapping("/")
	public List<Student> addStudent(@RequestBody Student stu) {
			
		repo.save(stu);
		System.out.println("Data Added Successfully");
		return repo.findAll();
				
		
	}
	
	//2nd way
	@PostMapping("/secondway")
	public List<Student> addStudent2(@RequestBody Student stu) {
		
		Register reg = regRepo.findById(stu.getRegister().getId()).get();
		
		List<Address> add = stu.getAddress();
		List<Address> result = new ArrayList<>();
		for(Address address : add) {
			Address a = addRepo.findById(address.getId()).get();
			result.add(a);
		}
		
		
		List<Teacher> result1 = new ArrayList<>();
		for(Teacher teacher : stu.getTeacher()) {
			Teacher teach = teaRepo.findById(teacher.getId()).get();
			result1.add(teach);
		}
			
		stu.setRegister(reg);
		stu.setAddress(result);
		stu.setTeacher(result1);
		repo.save(stu);
		System.out.println("Data Added Successfully");
		return repo.findAll();
				
		
	}
	
	@PutMapping("/")
	public List<Student> updateStudent(@RequestBody Student stu) {
		repo.save(stu);
		System.out.println("Data updated Successfully");
		return repo.findAll();
		
	}
	
	@DeleteMapping("/{id}")
	public List<Student> deleteStudent(@PathVariable("id") long id) {
		
		System.err.println("Deleted id is "+id);
		repo.deleteById(id);
		return repo.findAll();
	}
	
	
	
	
}