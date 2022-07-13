package com.example.employeepayrollapp.dto;

public class EmployeeDTO {
    public String name;
    public String gender;
    public String department;
    public long salary;

    public EmployeeDTO(String name, String gender, String department, long salary) {
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

}
