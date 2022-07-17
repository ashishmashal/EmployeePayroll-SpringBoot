package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.Employee;

import java.util.List;

public interface iEmployeeService {
    /*@Override
    public String employeeMessage(){
        return "Hello World!";
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }
    @Override
    public Employee saveEmployees(Employee employee){
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> findEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee editEmployee(Employee employee, Integer id) {
        Employee existingGreet = employeeRepository.findById(id).orElse(null);
        if (existingGreet != null) {
            existingGreet.setName(employee.getName()); ;
            return employeeRepository.save(existingGreet);
        }else return null;
    }

    public String deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return "Data Deleted";
    }*/
    List<Employee> getEmployeeData();

    Employee getEmployeePayrollDataById(int empId);

    Employee createEmployeePayrollData(EmployeeDTO employeeDTO);

    Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO);

    String deleteEmployeePayrollData(int empID);
    List<Employee> getEmployeesByDepartment(String department);
}
