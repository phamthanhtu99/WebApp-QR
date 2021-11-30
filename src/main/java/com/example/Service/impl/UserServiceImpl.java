package com.example.Service.impl;

import com.example.Common.ClassCommon;
import com.example.Dto.UserDTO;
import com.example.Entity.UserEntity;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ClassCommon classCommon;

    @Override
    public UserDTO save(UserDTO value) {
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
