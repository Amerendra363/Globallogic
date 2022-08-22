package com.example.demomany.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demomany.Entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
