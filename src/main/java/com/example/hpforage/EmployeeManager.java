package com.example.restservice;

import javax.annotation.PostConstruct;

public class EmployeeManager {
    private Employees employees = new Employees();

    @PostConstruct
    public void init() {
        employees.getEmployeeList().add(new Employee(1L, "John", "Doe", "john.doe@example.com", "Developer"));
        employees.getEmployeeList().add(new Employee(2L, "Jane", "Smith", "jane.smith@example.com", "Manager"));
        employees.getEmployeeList().add(new Employee(3L, "Jim", "Brown", "jim.brown@example.com", "Designer"));
    }

    public Employees getEmployees() {
        return employees;
    }
}
