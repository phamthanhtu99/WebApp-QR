package com.example.Convert;

import com.example.Dto.RoleDTO;
import com.example.Entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleConvert {
    public RoleDTO DTO(RoleEntity entily){
        RoleDTO  dto = new RoleDTO(entily.getId(),entily.geteRole());
        return dto;
    }
    public RoleEntity ENTITY(RoleDTO dto){
        RoleEntity roleEntily = new RoleEntity(dto.getId(),dto.getName());
        return roleEntily;
    }
}
