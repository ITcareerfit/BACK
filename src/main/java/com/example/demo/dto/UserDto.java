package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class UserDto {
    private String email;
    private String pw;
    private String userName;
    private String phone;
    private LocalDate birth;
    private List<String> pos;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
    
    public List<String> getPos() {
        return pos;
    }

    public void setPos(List<String> pos) {
        this.pos = pos;
    }
}

