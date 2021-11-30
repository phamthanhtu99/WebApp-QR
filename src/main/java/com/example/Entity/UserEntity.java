package com.example.Entity;


import com.example.Dto.RoleDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends Base{
    @Column
    private String Name;
    @Column String Phone;
    @Column String Address;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<RoleEntily> roleEntily = new ArrayList<>();

    public UserEntity(String name, String phone, String address, List<RoleEntily> roleEntily) {

        Name = name;
        Phone = phone;
        Address = address;
        this.roleEntily = roleEntily;
    }

    public UserEntity(Long id, String name, String phone, String address, List<RoleEntily> roleEntily) {
        super(id);
        Name = name;
        Phone = phone;
        Address = address;
        this.roleEntily = roleEntily;
    }

    public UserEntity() {

    }

    public List<RoleEntily> getRoleEntily() {
        return roleEntily;
    }

    public void setRoleEntily(List<RoleEntily> roleEntily) {
        this.roleEntily = roleEntily;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
