package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.example.demo.domain.COMPANY;

public class UserDto {
    private String email;
    private String pw;
    private String userName;
    private String phone;
    private LocalDate birth;
    private List<String> pos;
    private List<Integer> goodPosts;
    private COMPANY company1;
    private COMPANY company2;
    private COMPANY company3;
    private COMPANY company4;
    private COMPANY company5;
    private double grow;
    private double pay;
    private double profit;
    private double stable;
    private double scale;

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
    public List<Integer> getGoodPosts() {
        return goodPosts;
    }
    public void setGoodPosts(List<Integer> goodPosts) {
        this.goodPosts = goodPosts;
    }
    public COMPANY getCompany1() {
        return company1;
    }
    public void setCompany1(COMPANY company1) {
        this.company1 = company1;
    }
    public COMPANY getCompany2() {
        return company2;
    }
    public void setCompany2(COMPANY company2) {
        this.company2 = company2;
    }
    public COMPANY getCompany3() {
        return company3;
    }
    public void setCompany3(COMPANY company3) {
        this.company3 = company3;
    }
    public COMPANY getCompany4() {
        return company4;
    }
    public void setCompany4(COMPANY company4) {
        this.company4 = company4;
    }
    public COMPANY getCompany5() {
        return company5;
    }
    public void setCompany5(COMPANY company5) {
        this.company5 = company5;
    }
    public double getGrow() {
    	return grow;
    }
    public void setGrow(double grow) {
    	this.grow = grow;
    }
    public double getPay() {
    	return pay;
    }
    public void setPay(double pay) {
    	this.pay = pay;
    }
    public double getStable() {
    	return stable;
    }
    public void setStable(double stable) {
    	this.stable = stable;
    }
    public double getProfit() {
    	return profit;
    }
    public void setProfit(double profit) {
    	this.profit = profit;
    }
    public double getScale() {
    	return scale;
    }
    public void setScale(double scale) {
    	this.scale = scale;
    }
    
}

