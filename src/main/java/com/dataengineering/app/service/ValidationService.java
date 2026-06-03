package com.dataengineering.app.service;

import org.springframework.stereotype.Service;
import com.dataengineering.app.model.ValidationResult;
import com.dataengineering.app.entity.EmployeeRecord;

import java.util.HashSet;
import java.util.Set;

@Service
public class ValidationService {
    
    private final Set<Long> seenIds = new HashSet<>();

    public ValidationResult validate(
        EmployeeRecord employee) {

            if (employee.getName() == null ||
                employee.getName().isBlank()) {
                    return new ValidationResult(false, "Name is required");
            }

            if (employee.getSalary() < 0) {
                return new ValidationResult(false, "Salary must not be negative");
            }

            if (seenIds.contains(employee.getEmpId())) {
                return new ValidationResult(false, "Duplicate Employee ID");
            }

            seenIds.add(employee.getEmpId());

            return new ValidationResult(true, "VALID");       
    }
}
