package com.example.demo.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class techPK implements Serializable {
    private String techName;
    private int year;
    private int month;
    private String posName;
}
