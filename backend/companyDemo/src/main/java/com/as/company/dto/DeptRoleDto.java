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
public class DeptRoleDto {

    private long deptId;
    private String deptName;
    private long roleId;
    private String roleName;
    private long experience;
    private String location;

    
}
