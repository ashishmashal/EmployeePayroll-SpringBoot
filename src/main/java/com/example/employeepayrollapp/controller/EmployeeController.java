package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService service;
       /***********************************UC1**************************/
    @RequestMapping("/welcome")
    public String displayMessage(){
        return service.employeeMessage();
    }

    /***************************** UC2 ************************************/

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
    }
}
