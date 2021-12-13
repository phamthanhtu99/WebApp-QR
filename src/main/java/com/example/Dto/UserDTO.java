package com.example.Dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String Name;
    private String Phone;
    private String Address;
    private  String Password;
    private List<RoleDTO> role;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String phone, String address, String password, List<RoleDTO> role) {
        this.id = id;
        Name = name;
        Phone = phone;
        Address = address;
        Password = password;
        this.role = role;
    }

    public UserDTO(String name, String phone, String address, String password, List<RoleDTO> role) {
        Name = name;
        Phone = phone;
        Address = address;
        Password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<RoleDTO> getRole() {
        return role;
    }

    public void setRole(List<RoleDTO> role) {
        this.role = role;
    }
}
