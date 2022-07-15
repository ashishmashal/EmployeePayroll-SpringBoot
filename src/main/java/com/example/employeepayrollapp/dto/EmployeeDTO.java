package com.example.employeepayrollapp.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor
public class EmployeeDTO {
    @NotNull(message = "Employee Name Cannot be Null")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$" ,message = "Employee Name Is Incorrect.")
    public String name;
    @NotEmpty(message = "Gender Cannot Be Empty.")
    public String gender;
    @NotEmpty(message = "Department Cannot Be Empty.")
    public String department;
    @Min(value = 500,message = "Salary Should Be Minimum 500")
    public long salary;

}
