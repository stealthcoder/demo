package com.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.exception.ResourceNotFoundException;
import com.poc.model.Employee;
import com.poc.repo.EmployeeRepository;
import java.util.UUID;

import jakarta.annotation.Resource;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findEmployeesByLastNamePattern(String lastNamePattern) {
        return employeeRepository.findByLastNameContainingIgnoreCase(lastNamePattern);
    }

    @Override
    public Employee updateEmployee(Employee employee, UUID id) {
        Employee existingEmployee =  employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
        
    }

    @Override
    public Employee getEmployee(UUID id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employeeRepository.deleteById(id);
    }
    
}
