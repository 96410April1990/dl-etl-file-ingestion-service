package com.dataengineering.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dataengineering.app.entity.EmployeeFile;

public interface EmployeeFileRepository extends JpaRepository<EmployeeFile, Long> {
    
}
