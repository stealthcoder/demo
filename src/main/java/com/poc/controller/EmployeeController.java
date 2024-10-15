package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.poc.model.Employee;
import com.poc.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> findEmployeesByLastNamePattern(@RequestParam String lastName) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findEmployeesByLastNamePattern(lastName));
        // return employeeService.findEmployeesByLastNamePattern(lastName);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") UUID id, @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employee, id));
        // return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        // Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee)); // 201 CREATED

    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable UUID id) {
        return new ResponseEntity<Employee>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable UUID id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee successfully deleted.", HttpStatus.OK);
    }
    
}
