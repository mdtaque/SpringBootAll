package com.binarytech.employeeinfoservices.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Messages {

    @RequestMapping("/message")
    public String getMessage(){
        return "Hello Spring Boot!";
    }
}
