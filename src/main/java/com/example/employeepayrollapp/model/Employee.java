package com.example.employeepayrollapp.model;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class Employee {
   @Id
   @GeneratedValue
   private int id;
   private String name;
   @CollectionTable(name = "department", joinColumns = @JoinColumn(name = "id"))
   @ElementCollection
   private List<String> department;
   private String gender;
    private long salary;
   private LocalDate startDate;
  private String note;
   private String profilePic;


  public Employee(int empId,EmployeeDTO employeeDTO) {
      this.id = empId;
      this.name = employeeDTO.name;
      this.department = Collections.singletonList(String.valueOf(employeeDTO.department));
      this.gender = employeeDTO.gender;
      this.salary = employeeDTO.salary;
      this.startDate= employeeDTO.startDate;
      this.note = employeeDTO.note;
      this.profilePic = employeeDTO.profilePic;
  }

    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.name;
        this.department = Collections.singletonList(String.valueOf(employeeDTO.department));
        this.gender = employeeDTO.gender;
        this.salary = employeeDTO.salary;
        this.startDate= employeeDTO.startDate;
        this.note = employeeDTO.note;
        this.profilePic = employeeDTO.profilePic;
  }
}

