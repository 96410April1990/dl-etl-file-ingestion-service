package com.dataengineering.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataengineering.app.entity.EmployeeError;

@Repository
public interface EmployeeErrorRepository extends JpaRepository<EmployeeError, Long> {
    
}
