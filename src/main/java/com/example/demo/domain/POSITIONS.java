package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor // jpa 필수
@AllArgsConstructor
@ToString
@Entity(name = "positions")
public class POSITIONS {
	//https://wikidocs.net/161165
	@Id
	private String posName;
	
	@Column(nullable = false, length = 45)
	private String category;
	@Column
	private int total;
	private int year;
	private int month;
}
