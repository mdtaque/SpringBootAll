package com.binarytech.employeeinfoservices.rest;

import com.binarytech.employeeinfoservices.entity.Employee;
import com.binarytech.employeeinfoservices.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeProfile {

    public EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/get-profile", headers = "Accept=Application/json")
    public List<Employee> getProfile()  {
        return employeeService.retrieveEmployee();
    }

    @GetMapping(value = "/get-profile/{id}", headers = "Accept=Application/json")
    public Optional<Employee> getSingleProfile(@PathVariable Integer id)  {
        return employeeService.findById(id);
    }

    @PostMapping(value = "/post-profile", headers = "Accept=Application/json")
    public ResponseEntity<Void> createProfile(@RequestBody Employee employee, UriComponentsBuilder uriComponentsBuilder){
        employeeService.createEmployee(employee);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/api/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update-profile", headers = "Accept=application/json")
    public ResponseEntity<String> updateProfile(@RequestBody Employee currentEmployee){
        Optional<Employee> updatedEmployee = employeeService.findById(currentEmployee.getId());
        if(updatedEmployee==null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        employeeService.updateEmployee(currentEmployee, currentEmployee.getId());
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-profile/{id}", headers = "Accept=application/json")
    public ResponseEntity<String> deleteProfile(@PathVariable Integer id){
        Optional<Employee> employee = employeeService.findById(id);
        if(employee==null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }




}
