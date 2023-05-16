package com.example.demo.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class posPK implements Serializable {
	private String posName;
	private int year;
	private int month;
}
