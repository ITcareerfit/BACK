package com.example.demo.dto;

import java.util.List;

import com.example.demo.domain.COMPANY;

public class JobDto {

	private String company;
    private COMPANY cp_name;
    private String jobType;
    private int employee;
    private int pay;
    private int career;
    private List<String> job;
    private List<String> stack;
    
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getCpName(String name) {
        return name;
    }
    public void setCpName(COMPANY cp_name) {
        this.cp_name = cp_name;
    }
    public String getJobType() {
        return jobType;
    }
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    public Integer getEmployee() {
        return employee;
    }
    public void setEmployee(int employee) {
        this.employee = employee;
    }
    public Integer getPay() {
        return pay;
    }
    public void setPay(int pay) {
        this.pay = pay;
    }
    public Integer getCareer() {
        return career;
    }
    public void setCareer(int career) {
        this.career = career;
    }
    public List<String> getJob(){
    	return job;
    }
    public void setJob(List<String> job) {
    	this.job = job;
    }
    public List<String> getStack(){
    	return stack;
    }
    public void setStack(List<String> stack) {
    	this.stack = stack;
    }
}
