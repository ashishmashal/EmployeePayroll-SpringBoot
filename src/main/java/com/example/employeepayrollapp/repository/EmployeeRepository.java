package com.example.employeepayrollapp.repository;

import com.example.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
@Query(value = "select * from employee_payroll,employee_department where employee_id = id and department = department",nativeQuery = true)
    List<Employee> findEmployeeByDepartment(String department);
}
