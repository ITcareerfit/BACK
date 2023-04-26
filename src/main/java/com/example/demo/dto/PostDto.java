package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.example.demo.domain.COMPANY;

public class PostDto {
    private int infoId;
    private COMPANY infoCpName;
    private String title;
    private LocalDate deadline;
    private int type;
    private String infoLoc;
   // private String infoPos;
    private List<String> infoPos;
    //private String infoTech;
    private List<String> infoTech;
    private int minCareer;
    private int maxCareer;
    private int minPay;
    private int maxPay;
    private String infoUrl;
    private String content;
    
    public Integer getInfoId() {
        return infoId;
    }
    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }
    public COMPANY getInfoCpName() {
    	return infoCpName;
    }
    public void setInfoCpName(COMPANY infoCpName) {
    	this.infoCpName = infoCpName;
    }
    public String getTitle() {
    	return title;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    public LocalDate getDeadline() {
    	return deadline;
    }
    public void setDeadline(LocalDate deadline) {
    	this.deadline = deadline;
    }
    public Integer getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getInfoLoc() {
    	return infoLoc;
    }
    public void setInfoLoc(String infoLoc) {
    	this.infoLoc = infoLoc;
    }
    public List<String> getInfoPos() {
    	return infoPos;
    }
    public void setInfoPos(List<String> infoPos) {
    	this.infoPos = infoPos;
    }
    
    public List<String> getInfoTech() {
    	return infoTech;
    }
    public void setInfoTech(List<String> infoTech) {
    	this.infoTech = infoTech;
    }
	/*
	 * public List<String> getInfoPos() { return infoPos; } public void
	 * setInfoPos(List<String> infoPos) { this.infoPos = infoPos; } public
	 * List<String> getInfoTech() { return infoTech; } public void
	 * setInfoTech(List<String> infoTech) { this.infoTech = infoTech; }
	 */
    public Integer getMaxCareer() {
        return maxCareer;
    }
    public void setMaxCareer(int maxCareer) {
        this.maxCareer = maxCareer;
    }
    public Integer getMinCareer() {
        return minCareer;
    }
    public void setMinCareer(int minCareer) {
        this.minCareer = minCareer;
    }
    public Integer getMaxPay() {
        return maxPay;
    }
    public void setMaxPay(int maxPay) {
        this.maxPay = maxPay;
    }
    public Integer getMinPay() {
        return minPay;
    }
    public void setMinPay(int minPay) {
        this.minPay = minPay;
    }
    public String getInfoUrl() {
    	return infoUrl;
    }
    public void setInfoUrl(String infoUrl) {
    	this.infoUrl = infoUrl;
    }
    public String getContent() {
    	return content;
    }
    public void setContent(String content) {
    	this.content = content;
    }
}

