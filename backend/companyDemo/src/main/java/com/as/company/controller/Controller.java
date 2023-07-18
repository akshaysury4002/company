package com.as.company.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.company.dto.AppResponse;
import com.as.company.dto.DeptDto;
import com.as.company.dto.DeptRoleDto;
import com.as.company.dto.EmpRoleDto;
import com.as.company.dto.EmployeeDto;
import com.as.company.dto.RoleDto;
import com.as.company.service.EmpService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping(value = "/company")
@RestController
public class Controller {

    private final EmpService service;

    @CrossOrigin
    @PostMapping(value = "/dept", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewDept(@Valid @RequestBody DeptDto dto)
    {
       final Integer sts= service.createNewDept(dto);

       final AppResponse<Integer> response= AppResponse.<Integer>builder()
                                                   .sts("success")
                                                   .msg("dept created Succesfully")
                                                   .bd(sts)
                                                   .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


    @CrossOrigin
    @PostMapping(value = "/application", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewUser(@Valid @RequestBody EmployeeDto dto)
    {
       final Integer sts= service.createNewUser(dto);

       final AppResponse<Integer> response= AppResponse.<Integer>builder()
                                                   .sts("success")
                                                   .msg("User created Succesfully")
                                                   .bd(sts)
                                                   .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


    @CrossOrigin
    @PostMapping(value = "/role", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createNewRole(@Valid @RequestBody RoleDto dto)
    {
       final Integer sts= service.createNewRole(dto);

       final AppResponse<Integer> response= AppResponse.<Integer>builder()
                                                   .sts("success")
                                                   .msg("role created Succesfully")
                                                   .bd(sts)
                                                   .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

     @CrossOrigin
    @PostMapping(value = "/{deptId}/role", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> mapRole(@Valid @PathVariable Long deptId, @RequestBody RoleDto dto) {
        Integer sts = service.mapRole(deptId,dto);
        AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("Application submitted.")
                .bd(sts)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @CrossOrigin
    @PostMapping(value = "/{roleId}/employee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> mapApplication(@Valid @PathVariable Long roleId, @RequestBody EmployeeDto dto) {
        Integer sts = service.mapApplication(roleId,dto);
        AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("Application submitted.")
                .bd(sts)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    

    @CrossOrigin
    @GetMapping(value = "/getemployee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<EmployeeDto>>> allUsers() {
        List<EmployeeDto> users = service.all();

        AppResponse<List<EmployeeDto>> response = AppResponse.<List<EmployeeDto>>builder()
                                                            .sts("success")
                                                            .msg("users")
                                                            .bd(users)
                                                            .build();

        return ResponseEntity.ok().body(response);
    }

    @CrossOrigin
    @GetMapping(value = "/getdept", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<DeptDto>>> allDept() {
        List<DeptDto> dept = service.allDept();

        AppResponse<List<DeptDto>> response = AppResponse.<List<DeptDto>>builder()
                                                            .sts("success")
                                                            .msg("departments")
                                                            .bd(dept)
                                                            .build();

        return ResponseEntity.ok().body(response);
    }


    @CrossOrigin
    @GetMapping(value = "/getroles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<RoleDto>>> allRole() {
        List<RoleDto> users = service.allRoles();

        AppResponse<List<RoleDto>> response = AppResponse.<List<RoleDto>>builder()
                                                            .sts("success")
                                                            .msg("roles")
                                                            .bd(users)
                                                            .build();

        return ResponseEntity.ok().body(response);
    }


    @CrossOrigin
    @GetMapping(value = "/getEmp/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<EmpRoleDto>>> findAll(@PathVariable Long roleId) {

         List<EmpRoleDto> users = service.getAllEmployee(roleId);

        AppResponse<List<EmpRoleDto>> response = AppResponse.<List<EmpRoleDto>>builder()
                                                            .sts("success")
                                                            .msg("applications")
                                                            .bd(users)
                                                            .build();

        return ResponseEntity.ok().body(response);
    }

    @CrossOrigin
    @GetMapping(value = "/getrole/{DeptId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<DeptRoleDto>>> getAllRole(@PathVariable Long DeptId) {

         List<DeptRoleDto> users = service.getAllRole(DeptId);

        AppResponse<List<DeptRoleDto>> response = AppResponse.<List<DeptRoleDto>>builder()
                                                            .sts("success")
                                                            .msg("roles")
                                                            .bd(users)
                                                            .build();

        return ResponseEntity.ok().body(response);
    }


   


    
}
