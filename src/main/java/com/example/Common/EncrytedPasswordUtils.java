package com.example.Common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncrytedPasswordUtils {
    public  String encrytePassword(String pass){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return  encoder.encode(pass);
    }
}
