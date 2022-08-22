package com.example.BookStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.entity.admin;

public interface AdminRepo extends JpaRepository<admin, Long> {
	

}
