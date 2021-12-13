package com.example.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column
    private ERole eRole;

    @ManyToMany(mappedBy = "roleEntity")
    private List<UserEntity> users = new ArrayList<>();

    public List<UserEntity> getUsers() {
        return users;
    }
    @OneToMany(mappedBy = "store")
    private List<ProductEntity> productEntities =new ArrayList<>();

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public RoleEntity(Long id, ERole eRole) {
        super(id);
        this.eRole = eRole;
    }

    public RoleEntity() {

    }

    public ERole geteRole() {
        return eRole;
    }

    public void seteRole(ERole eRole) {
        this.eRole = eRole;
    }

    public List<UserEntity> getUserEntities() {
        return users;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.users = userEntities;
    }
}
