package com.globallogic.DepartmentServices.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.DepartmentServices.entity.DeptEntity;

@Repository
public interface DeptRepo extends JpaRepository<DeptEntity, Long> {

}
