package com.example.BookStore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookStore.entity.book;

public interface BookRepo extends JpaRepository<book, Long>{

}
