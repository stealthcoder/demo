package com.poc.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID>{
 
    List<Employee> findByLastNameContainingIgnoreCase(String lastName);
}
