package com.example.Convert;

import com.example.Dto.RoleDTO;
import com.example.Entity.RoleEntily;
import org.springframework.stereotype.Component;

@Component
public class RoleConvert {
    public RoleDTO DTO(RoleEntily entily){
        RoleDTO  dto = new RoleDTO(entily.getId(),entily.geteRole());
        return dto;
    }
    public RoleEntily ENTITY(RoleDTO dto){
        RoleEntily roleEntily = new RoleEntily(dto.getId(),dto.getName());
        return roleEntily;
    }
}
