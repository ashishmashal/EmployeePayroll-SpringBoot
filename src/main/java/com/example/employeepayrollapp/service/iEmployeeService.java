package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.model.Employee;

import java.util.List;

public interface iEmployeeService {
    public String employeeMessage();

    Employee findEmployeeById(Integer id);

    Employee saveEmployees(Employee employee);

    List<Employee> findEmployees();

    Employee editEmployee(Employee employee, Integer id);
}
