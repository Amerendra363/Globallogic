package com.globallogic.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.book.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
