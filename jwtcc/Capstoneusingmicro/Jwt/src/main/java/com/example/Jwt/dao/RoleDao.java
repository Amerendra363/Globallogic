package com.example.Jwt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Jwt.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role,String>{

}
