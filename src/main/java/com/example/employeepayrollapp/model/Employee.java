package com.example.employeepayrollapp.model;

import com.example.employeepayrollapp.dto.EmployeeDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Employee {
    int id;
    String name;
    String department;
    String gender;
    long salary;

    public Employee() {
    }

  /*  public Employee(int id, String name, String department, String gender, long salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.gender = gender;
        this.salary = salary;
    }
*/
  public Employee(int empId,EmployeeDTO employeeDTO) {
      this.id = empId;
      this.name = employeeDTO.name;
      this.department = employeeDTO.department;
      this.gender = employeeDTO.gender;
      this.salary = employeeDTO.salary;
  }

    @Id //primary key
    @GeneratedValue //auto value

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
