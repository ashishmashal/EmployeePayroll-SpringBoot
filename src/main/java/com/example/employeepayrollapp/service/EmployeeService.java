package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements iEmployeeService {
   /* @Autowired
    EmployeeRepository employeeRepository;*/

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
    @Override
    public List<Employee> getEmployeeData() {
        List<Employee> empDataList = new ArrayList<>();
        empDataList.add(new Employee(1, new EmployeeDTO("Ashish", "male", "Sales", 35000)));
        return empDataList;
    }
    @Override
    public Employee getEmployeePayrollDataById(int empId) {
        Employee  empData= null;
        empData= new Employee (1, new EmployeeDTO("Ashish", "male", "Sales", 35000));
        return empData;
    }
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO){
        Employee empData= null;
        empData= new Employee(1, employeeDTO);
        return empData;
    }
    @Override
    public Employee updateEmployeePayrollData(EmployeeDTO employeeDTO) {
        Employee empData= null;
        empData = new Employee(1, employeeDTO);
        return empData;
    }

    public void deleteEmployeePayrollData(int empID) {
    }
}
