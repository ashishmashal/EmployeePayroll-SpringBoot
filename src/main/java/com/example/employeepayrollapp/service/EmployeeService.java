package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.exception.EmployeePayrollException;
import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements iEmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeeData() {
       return employeeRepository.findAll();
    }
    @Override
    public Employee  getEmployeePayrollDataById(int empId) {
        return employeeRepository.findById(empId).orElseThrow(() -> new EmployeePayrollException("Employee Id With " +
                empId + "Does Not Exist"));
    }
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO){
        Employee empData = new Employee(employeeDTO);
        return employeeRepository.save(empData);

    }
    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO){
            Employee empData = this.getEmployeePayrollDataById(empId);
            empData.setName(employeeDTO.name);
            empData.setDepartment(Collections.singletonList(String.valueOf(employeeDTO.department)));
            empData.setGender(employeeDTO.gender);
            empData.setSalary(employeeDTO.salary);
            empData.setNote(employeeDTO.note);
            empData.setProfilePic(employeeDTO.profilePic);
            empData.setStartDate(employeeDTO.startDate);
            employeeRepository.save(empData);
            return empData;
        }
     @Override
     public String deleteEmployeePayrollData(int empID) {
         employeeRepository.deleteById(empID);
         return "Data Deleted";
    }
}
