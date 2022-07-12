package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmpAPIs {
    public static final String template = "Hello & Welcome to the Employee Payroll App, %s";
    @Autowired
    public EmployeeService service;

    @RequestMapping("/welcome")
    public String displayMessage(){
        return service.employeeMessage();
    }
}
