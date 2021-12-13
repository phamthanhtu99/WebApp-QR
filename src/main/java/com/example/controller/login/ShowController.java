package com.example.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowController {
    @GetMapping("/Show/form_add")
    public String homeStore(){
        return "/store/component/formAddProduct";
    }


}
