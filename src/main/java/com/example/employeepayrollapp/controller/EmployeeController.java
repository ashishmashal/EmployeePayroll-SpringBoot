package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.dto.ResponseDTO;
import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.service.iEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
public class EmployeeController {
    @Autowired
    iEmployeeService service;
    List <Employee> empDatalist = new ArrayList<>();

    //ResponseEntity check Status and store in json format
    @RequestMapping(value = {"","/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        empDatalist = service.getEmployeeData();
        ResponseDTO respOTO = new ResponseDTO("Get Call Successful", empDatalist);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empID) {
        Employee empData= null;
        empData = service.getEmployeePayrollDataById(empID);
        ResponseDTO respDTO= new ResponseDTO("Get Call For ID Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

   @PostMapping("/add")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(
           @Valid @RequestBody EmployeeDTO empPayrollDTO) {
        Employee empData = service.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respOTO= new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empID}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empID") int empID, @Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee empData = null;
        empData = service.updateEmployeePayrollData(empID,employeeDTO);
        ResponseDTO respDTO= new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity <ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity <ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        service.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO= new ResponseDTO("Deleted Successfully", "Deleted id: "+empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
