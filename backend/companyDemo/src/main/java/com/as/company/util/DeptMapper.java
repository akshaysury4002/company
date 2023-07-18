package com.as.company.util;

import org.springframework.stereotype.Component;
import com.as.company.domain.Department;
import com.as.company.dto.DeptDto;


@Component
public class DeptMapper {

     public Department toDomain(DeptDto dto)
    {
        return new Department(dto.getDeptId(),dto.getDeptName(), null);
        
    }

   public DeptDto toDto(Department domain)
    {
        return new DeptDto(domain.getDeptId(),domain.getDeptName());
    }

    
}
