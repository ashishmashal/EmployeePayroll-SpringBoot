package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.exception.EmployeePayrollException;
import com.example.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements iEmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
   /* @Autowired
    EmployeeRepository employeeRepository;*/

    @Override
    public List<Employee> getEmployeeData() {
       return employeeList;
    }
    @Override
    public Employee  getEmployeePayrollDataById(int empId) {
            return employeeList.stream()
            .filter(empData -> empData.getId() == empId)
            .findFirst()
            .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO){
        Employee empData= null;
        empData= new Employee(employeeList.size()+1, employeeDTO);
        employeeList.add(empData);
        return empData;
    }
    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO){
            Employee empData = this.getEmployeePayrollDataById(empId);
            empData.setName(employeeDTO.name);
            empData.setDepartment(employeeDTO.department);
            empData.setGender(employeeDTO.gender);
            empData.setSalary(employeeDTO.salary);
            employeeList.set(empId - 1, empData);
            return empData;
        }
     @Override
     public void deleteEmployeePayrollData(int empID) {
        employeeList.remove(empID-1);
    }
}
