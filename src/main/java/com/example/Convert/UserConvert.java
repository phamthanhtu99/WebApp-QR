package com.example.Convert;

import com.example.Dto.RoleDTO;
import com.example.Dto.UserDTO;
import com.example.Entity.RoleEntity;
import com.example.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConvert {
    @Autowired
    private RoleConvert convert;
    public UserDTO DTO(UserEntity entity){
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for (RoleEntity item : entity.getRoleEntily()){
            roleDTOS.add(convert.DTO(item));
        }
        UserDTO  dto = new UserDTO(entity.getId(), entity.getName(), entity.getPhone(), entity.getAddress(),entity.getPassword(), roleDTOS);
        return dto;
    }
    public UserEntity ENTITY(UserDTO dto){
        List<RoleEntity> list = new ArrayList<>();
        for (RoleDTO item:dto.getRole() ) {
            list.add(convert.ENTITY(item));
        }
        UserEntity userEntity = new UserEntity(dto.getId(), dto.getName(),dto.getPhone(),dto.getAddress(),dto.getPassword(),list );
        return userEntity;
    }
}
