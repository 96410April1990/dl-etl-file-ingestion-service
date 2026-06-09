package com.dataengineering.app.kafka;

public class EmployeeEvent {

    private String eventId;
    private Long empId;
    private String name;
    private Double salary;
    private String department;

    public EmployeeEvent() {}

    public EmployeeEvent(
        String eventId,
        Long empId,
        String name,
        Double salary,
        String department) {

            this.eventId = eventId;
            this.empId = empId;
            this.name = name;
            this.salary = salary;
            this.department = department;

    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
