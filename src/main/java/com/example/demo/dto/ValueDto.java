package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.example.demo.domain.COMPANY;

public class ValueDto {

	private int userNum;
	private Double grow;
    private Double pay;
    private Double profit;
    private Double stable;
    private Double scale;
	
    public int getUserNum() {
    	return userNum;
    }
    public void setUserNum(int userNum) {
    	this.userNum = userNum;
    }
    public double getGrow() {
    	return grow;
    }
    public void setGrow(Double grow) {
    	this.grow = grow;
    }
    public Double getPay() {
    	return pay;
    }
    public void setPay(Double pay) {
    	this.pay = pay;
    }
    public Double getStable() {
    	return stable;
    }
    public void setStable(Double stable) {
    	this.stable = stable;
    }
    public Double getProfit() {
    	return profit;
    }
    public void setProfit(Double profit) {
    	this.profit = profit;
    }
    public Double getScale() {
    	return scale;
    }
    public void setScale(Double scale) {
    	this.scale = scale;
    }
}
