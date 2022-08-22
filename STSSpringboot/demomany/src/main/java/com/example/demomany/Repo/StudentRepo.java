package com.example.demomany.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomany.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
