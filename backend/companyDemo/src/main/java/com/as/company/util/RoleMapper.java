package com.as.company.util;

import org.springframework.stereotype.Component;

import com.as.company.domain.Role;

import com.as.company.dto.RoleDto;

@Component
public class RoleMapper {

     public Role toDomain(RoleDto dto)
    {
        return new Role(dto.getRoleId(),dto.getRoleName(),dto.getExperience(),dto.getLocation(), null, null);
        
    }

   public RoleDto toDto(Role domain)
    {
        return new RoleDto(domain.getRoleId(),domain.getRoleName(),domain.getExperience(),domain.getLocation());
    }
    
}
