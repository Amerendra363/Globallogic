package com.example.BookStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.entity.user;

public interface UserRepo extends JpaRepository<user,Long> {

}
