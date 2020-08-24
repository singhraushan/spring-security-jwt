package com.rau.learning.auth.springsecurityjwt.dto;

import com.rau.learning.auth.springsecurityjwt.model.Role;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class RegistrationDto implements Serializable {

    private String userName;
    private String password;
    private String email;
    private List<Role> roles;
    private String personName;
    private LocalDate dob;
    private String contact;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
