package com.example.API;

import com.example.Common.ClassCommon;
import com.example.Dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController("/v1")
@Transactional
public class UserAPI {
    @Autowired
    private ClassCommon classCommon;
    @PostMapping("/user")
    public ResponseEntity<?> save (@RequestBody UserDTO dto){
       dto= classCommon.userService.save(dto);
        return ResponseEntity.ok(dto);
    }
}
