package com.dataengineering.app.entity;

public class EmployeeRecord {

    private Long empId;
    private String name;
    private Double salary;
    private String department;

    public EmployeeRecord(
        Long empId,
        String name,
        Double salary,
        String department) {
            this.empId = empId;
            this.name = name;
            this.salary = salary;
            this.department = department;
    }

    public Long getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
    
}
