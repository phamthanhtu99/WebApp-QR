package com.example.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntily extends Base{
   @Enumerated(EnumType.STRING)
    @Column
    private ERole eRole;

   @ManyToMany(mappedBy = "roleEntily")
    List<UserEntity>userEntities = new ArrayList<>();

    public RoleEntily(Long id, ERole eRole) {
        super(id);
        this.eRole = eRole;
        this.userEntities = userEntities;
    }

    public RoleEntily(ERole eRole, List<UserEntity> userEntities) {
        this.eRole = eRole;
        this.userEntities = userEntities;
    }

    public RoleEntily() {

    }

    public ERole geteRole() {
        return eRole;
    }
    public void seteRole(ERole eRole) {
        this.eRole = eRole;
    }
}
