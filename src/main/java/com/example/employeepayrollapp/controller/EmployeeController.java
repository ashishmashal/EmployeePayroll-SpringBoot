package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.dto.ResponseDTO;
import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;
    /***********************************UC1**************************/
    /*@RequestMapping("/welcome")
    public String displayMessage(){
        return service.employeeMessage();
    }

    */

    /***************************** UC2 ************************************//*

    @GetMapping("/employeeById/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return service.findEmployeeById(id);
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployees(employee);
    }

    @GetMapping("/allEmployees")
    public List<Employee> findAllEmployees() {
        return service.findEmployees();
    }
     @PutMapping("/editEmployee/{id}")
    public Employee editEmployee(@RequestBody Employee employee, @PathVariable Integer id){
        return service.editEmployee(employee, id);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        service.deleteEmployee(id);
        return "Data Deleted";
    }*/
    @RequestMapping(value = {"", "/ ", "get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        Employee empData = null;
        empData = new Employee(1, new EmployeeDTO("Ashish", "Male", "HR", 35000));
        ResponseDTO respOTO = new ResponseDTO("Get Call Successful", empData);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }
    @GetMapping("/get/{empId}")
    public ResponseEntity <ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        Employee empData = null;
        empData = new Employee(1, new EmployeeDTO("Ashish", "Male", "HR", 35000));
        ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeeDTO empDTO) {
        Employee empData = null;
        empData = new Employee(1, empDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseDTO> editEmployeePayrollData(@RequestBody EmployeeDTO empDTO) {
        Employee empData = null;
        empData = new Employee(1, empDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDTO respOTO= new ResponseDTO("Deleted Successfully", "Deleted id: "+empId);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
        }
}
