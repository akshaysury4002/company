package com.as.company.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.as.company.domain.Department;
import com.as.company.domain.Employee;
import com.as.company.domain.Role;
import com.as.company.dto.DeptDto;
import com.as.company.dto.DeptRoleDto;
import com.as.company.dto.EmpRoleDto;
import com.as.company.dto.EmployeeDto;
import com.as.company.dto.RoleDto;
import com.as.company.exception.EmployeeNotFoundException;
import com.as.company.exception.RoleNotFoundException;
import com.as.company.repository.DeptRepository;
import com.as.company.repository.EmpRepo;
import com.as.company.repository.RoleRepository;
import com.as.company.util.DeptMapper;
import com.as.company.util.DynamicMapper;
import com.as.company.util.EmployeeMapper;
import com.as.company.util.RoleMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class EmpServiceImpl implements EmpService {

    private final EmpRepo repository;
    private final RoleRepository repositories;
    private final DeptRepository repo;

    private final EmployeeMapper mapper;
    private final RoleMapper mappers;
    private final DeptMapper deptMapper;


    private final DynamicMapper dynamicMapper;

    @Override
    public Integer createNewUser(EmployeeDto emp) {

        repository.save(mapper.toDomain(emp));
        return 1;

    }

    @Override
    public Integer createNewRole(RoleDto role) {
        repositories.save(mappers.toDomain(role));
        return 1;
    }

    @Override
    public Integer createNewDept(DeptDto dept) {

        repo.save(deptMapper.toDomain(dept));
        return 1;
    }



    @Override
    public List<EmployeeDto> all() {
        return repository.findAll()
                .stream()
                // .map( invoice -> mapper.toDto(invoice) )
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

     @Override
    public List<DeptDto> allDept() {
         return repo.findAll()
                .stream()
                // .map( invoice -> mapper.toDto(invoice) )
                .map(deptMapper::toDto)
                .collect(Collectors.toList());
    }

    

    @Override
    public Integer mapRole(Long deptId, RoleDto dto) {
       Department department = repo.findById(deptId)
                .orElseThrow(() -> new RoleNotFoundException("dept not Found for " + deptId + " id"));

        Role role = dynamicMapper.convertor(dto, new Role());
        role.setDepartment(department);
        repositories.save(role);
        return 1;
    }


    @Override
    public Integer mapApplication(Long id, EmployeeDto dto) {
        Role role = repositories.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("role not Found for " + id + " id"));

        Employee employee = dynamicMapper.convertor(dto, new Employee());
        employee.setRole(role);
        repository.save(employee);
        return 1;
    }



    @Override
    public List<RoleDto> allRoles() {
         return repositories.findAll()
                .stream()
                // .map( invoice -> mapper.toDto(invoice) )
                .map(mappers::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmpRoleDto> getAllEmployee(Long roleId) {
        Role user = repositories.findById(roleId)
                .orElseThrow(() -> new RoleNotFoundException("No role found for " + roleId + " ID"));

            List<EmpRoleDto> collect = user.getEmployees()
            .stream()
            .map(employee -> dynamicMapper.convertor(employee, new EmpRoleDto()))
            .collect(Collectors.toList());
    if (collect.isEmpty())
        throw new EmployeeNotFoundException("No Application found.");

    return collect;
    }

    @Override
    public List<DeptRoleDto> getAllRole(Long deptId) {
        Department department = repo.findById(deptId)
                .orElseThrow(() -> new RoleNotFoundException("No Dept found for " + deptId + " ID"));

        List<DeptRoleDto> collect = department.getRoles()
                .stream()
                .map(employee -> dynamicMapper.convertor(employee, new DeptRoleDto()))
                .collect(Collectors.toList());
        if (collect.isEmpty())
            throw new EmployeeNotFoundException("No role found.");

        return collect;
    }

   
 

  

  

}
