package com.example.demomany.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomany.Entity.Register;

public interface RegisterRepo extends JpaRepository<Register, Long> {

}
