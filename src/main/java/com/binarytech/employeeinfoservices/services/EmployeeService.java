package com.binarytech.employeeinfoservices.services;

import com.binarytech.employeeinfoservices.entity.Employee;
import com.binarytech.employeeinfoservices.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public List<Employee> retrieveEmployee(){
        List<Employee> listOfEmployee = (List<Employee>) employeeRepository.findAll();
        return listOfEmployee;
    }

    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Optional<Employee> findById(Integer id){
        Optional<Employee> employeeId = employeeRepository.findById(id);
        return employeeId;
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Employee employee, Integer id){
        return employeeRepository.save(employee);
    }



}
