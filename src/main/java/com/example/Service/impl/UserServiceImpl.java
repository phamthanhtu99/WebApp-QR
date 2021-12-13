package com.example.Service.impl;

import com.example.Common.ClassCommon;
import com.example.Common.EncrytedPasswordUtils;
import com.example.Dto.RoleDTO;
import com.example.Dto.UserDTO;
import com.example.Entity.ERole;
import com.example.Entity.UserEntity;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ClassCommon classCommon;
    @Autowired
    private EncrytedPasswordUtils encrytedPasswordUtils;
    @Override
    public UserDTO save(UserDTO value) {
        List<RoleDTO> role = new ArrayList<>();
        role.add(new RoleDTO(1L, ERole.ROLE_USER));
        value.setRole(role);
        value.setId(0L);
        value.setPassword(encrytedPasswordUtils.encrytePassword(value.getPassword()));
        UserEntity entity = classCommon.userConvert.ENTITY(value);
        return classCommon.userConvert.DTO(classCommon.userRepository.save(entity));
    }

    @Override
    public UserDTO upate(UserDTO value) {
        return null;
    }

    @Override
    public boolean delete(long[] longs) {
        return false;
    }
}
