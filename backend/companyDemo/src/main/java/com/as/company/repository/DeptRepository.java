package com.as.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.company.domain.Department;

public interface DeptRepository extends JpaRepository<Department, Long>  {
    
}
