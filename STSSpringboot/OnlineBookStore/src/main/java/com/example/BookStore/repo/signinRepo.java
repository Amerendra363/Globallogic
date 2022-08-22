package com.example.BookStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.entity.Signup;

public interface signinRepo extends JpaRepository<Signup, Long> {

}
