package com.example.Jwt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.Jwt.entity.User;

@Repository
public interface UserDao extends CrudRepository<User,String>{

}
