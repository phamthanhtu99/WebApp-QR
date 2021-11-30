package com.example.controller;

import com.example.Dto.RoleDTO;
import com.example.Dto.UserDTO;
import com.example.Entity.ERole;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeControllwe {
    @Autowired
    private UserService userService;
    @GetMapping("/home")
    public String home(){
        List<RoleDTO> role = new ArrayList<>();
        role.add(new RoleDTO(1L, ERole.ROLE_USER));
        UserDTO dto = new UserDTO("TÚ","0366925447","Đại hiêp",role);
        userService.save(dto);
        return "ok";
    }
}
