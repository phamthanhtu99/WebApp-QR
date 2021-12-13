package com.example.Service.impl;

import com.example.Entity.RoleEntity;
import com.example.Entity.UserEntity;
import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceLayer implements UserDetailsService {
    @Autowired
    private UserRepository classCommon;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user= classCommon.findByPhone(s);
        if (user==null){
            throw new UsernameNotFoundException("không có user");
        }
        List<RoleEntity> entilySet = user.getRoleEntily();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (RoleEntity item:entilySet    ) {
            grantedAuthorities.add(new SimpleGrantedAuthority(item.geteRole().toString()));
        }
        UserDetails details = new User(user.getName(),user.getPassword(),grantedAuthorities);
        return details;
    }
}
