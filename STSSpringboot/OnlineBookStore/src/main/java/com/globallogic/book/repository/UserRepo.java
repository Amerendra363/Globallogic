package com.globallogic.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.book.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
