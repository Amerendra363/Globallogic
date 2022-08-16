package com.example.demoEcommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoEcommerce.entity.MerchantEntity;

public interface MerchantRepo extends JpaRepository<MerchantEntity, Integer> {

}
