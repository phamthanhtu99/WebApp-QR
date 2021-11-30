package com.example.Dto;

import com.example.Entity.ERole;

public class RoleDTO {
    private Long id;
    private ERole name;

    public RoleDTO(Long id, ERole name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
