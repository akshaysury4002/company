package com.as.company.service;


import java.util.List;

import com.as.company.dto.DeptDto;
import com.as.company.dto.DeptRoleDto;
import com.as.company.dto.EmpRoleDto;
import com.as.company.dto.EmployeeDto;
import com.as.company.dto.RoleDto;

public interface EmpService {

    Integer createNewUser(EmployeeDto emp);

    Integer createNewRole(RoleDto role);

    Integer createNewDept(DeptDto dept);

    List<EmployeeDto> all();

    List<DeptDto> allDept();

    List<RoleDto> allRoles();

    Integer mapRole(Long deptId , RoleDto dto); 

    Integer mapApplication(Long id, EmployeeDto dto); 

    List<DeptRoleDto> getAllRole(Long deptId);

    List<EmpRoleDto> getAllEmployee(Long roleId);

   

   
}
