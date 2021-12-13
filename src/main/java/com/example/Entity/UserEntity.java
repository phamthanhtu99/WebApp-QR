package com.example.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    @Column
    private String name;
    @Column String phone;
    @Column String address;
    @Column String password;

    public UserEntity(Long id, String name, String phone, String address, String password, List<RoleEntity> roleEntily) {
        super(id);
        this.name = name;
        this.  phone = phone;
        this.address = address;
        this.password = password;
        this.roleEntity = roleEntily;
    }
    @ManyToMany
    @JoinTable(name = "store_user",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "store_id"))
    private  List<StoreEntity> storeEntityList = new ArrayList<>();

    public List<StoreEntity> getStoreEntityList() {
        return storeEntityList;
    }

    public void setStoreEntityList(List<StoreEntity> storeEntityList) {
        this.storeEntityList = storeEntityList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roleEntity = new ArrayList<>();

    public UserEntity(String name, String phone, String address, List<RoleEntity> roleEntity) {

        this.name = name;
        this.  phone = phone;
        this.address = address;
        this.roleEntity = roleEntity;
    }

    public UserEntity(Long id, String name, String phone, String address, List<RoleEntity> roleEntily) {
        super(id);
        this.name = name;
        this.  phone = phone;
        this.address = address;
        this.roleEntity = roleEntily;
    }

    public List<RoleEntity> getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(List<RoleEntity> roleEntity) {
        this.roleEntity = roleEntity;
    }

    public UserEntity() {

    }

    public List<RoleEntity> getRoleEntily() {
        return roleEntity;
    }

    public void setRoleEntily(List<RoleEntity> roleEntily) {
        this.roleEntity = roleEntily;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
