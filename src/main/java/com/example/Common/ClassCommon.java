package com.example.Common;

import com.example.Convert.RoleConvert;
import com.example.Convert.UserConvert;
import com.example.Entity.UserEntity;
import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassCommon {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public UserConvert userConvert;
    @Autowired
    public RoleConvert roleConvert;
}
