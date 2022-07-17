package com.example.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
public @ToString class EmployeeDTO {
    //@NotNull(message = "Employee Name Cannot be Null")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$" ,message = "Employee Name Is Incorrect.")
    public String name;
    @NotEmpty(message = "Gender Cannot Be Empty.")
    @Pattern(regexp = "male|female",message = "Gender Need To be Male Or Female")
    public String gender;
    @NotEmpty(message = "Department Cannot Be Empty.")
    public List<String> department;
    @Min(value =500,message = "Salary Should Be Minimum 500")
    public long salary;

    @NotEmpty(message = "Profile Pic Cannot Be Empty.")
    public String profilePic;

    @NotEmpty(message = "Notes Cannot Be Empty.")
    public String note;
    @NotEmpty(message = "Start Date Cannot Be Empty.")
    @JsonFormat(pattern = "dd MM yyyy")
    @PastOrPresent(message = "Starts Date Should Be Past Or Today Date")
    public LocalDate startDate;
}
