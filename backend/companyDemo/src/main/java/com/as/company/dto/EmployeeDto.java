package com.as.company.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class EmployeeDto {
    
    private long id;

    @NotEmpty(message = "password cant be empty")
    @NotNull(message = "password cant be null")
    @NotBlank(message = "password cant be blank")
    private String name;

    @NotEmpty(message = "password cant be empty")
    @NotNull(message = "password cant be null")
    @NotBlank(message = "password cant be blank")
    private String email;
   
    private long contactNo;

    private long totalExp;

    private double currentCtc;

    private double expectedCtc;

    @NotEmpty(message = "password cant be empty")
    @NotNull(message = "password cant be null")
    @NotBlank(message = "password cant be blank")
    private String skills;

}
