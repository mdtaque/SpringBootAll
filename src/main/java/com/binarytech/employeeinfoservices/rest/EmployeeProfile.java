package com.binarytech.employeeinfoservices.rest;

import com.binarytech.employeeinfoservices.entity.Employee;
import com.binarytech.employeeinfoservices.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeProfile {

    public EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/profile")
    public List<Employee> getProfile(){
        return employeeService.retrieveEmployee();
    }




}
