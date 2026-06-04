package com.dataengineering.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataengineering.app.entity.EmployeeRaw;

@Repository
public interface EmployeeRawRepository extends JpaRepository<EmployeeRaw, Long> {
    
}
