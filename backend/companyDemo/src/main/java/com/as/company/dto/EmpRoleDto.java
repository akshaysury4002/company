package com.as.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpRoleDto {


    private long roleId;

    private String roleName;
    
    private long id;
   
    private String name;

    private String email;

    private long contactNo;

    private long totalExp;

    private double currentCtc;

    private double expectedCtc;

    private String skills;


    
}
