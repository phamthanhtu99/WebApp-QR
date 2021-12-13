package com.example.controller.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.WebUtils;

import java.security.Principal;

@Controller
public class loginController {
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/staff")
    public String homeStaff(){
        return "/staff/home";
    }



    @GetMapping("/store")
    public String homeStore(){
        return "/store/home";
    }


    @GetMapping("/")
    public String homeWeb(Model model, Principal principal){
//        User user= (User) ((Authentication) principal).getPrincipal();
        return "/web/home";
    }
}
