package com.poc.service;

import java.util.List;
import java.util.UUID;

import com.poc.model.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    List<Employee> findEmployeesByLastNamePattern(String lastNamePattern);
    Employee updateEmployee(Employee employee, UUID id);
    Employee getEmployee(UUID id);
    void deleteEmployee(UUID id);
}

