package com.example.demomany.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomany.Entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Long>{

}
