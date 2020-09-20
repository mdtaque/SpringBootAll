package com.binarytech.employeeinfoservices.services;

import com.binarytech.employeeinfoservices.entity.Employee;
import com.binarytech.employeeinfoservices.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public List<Employee> retrieveEmployee(){
        List<Employee> listOfEmployee = (List<Employee>) employeeRepository.findAll();
        return listOfEmployee;
    }



}
