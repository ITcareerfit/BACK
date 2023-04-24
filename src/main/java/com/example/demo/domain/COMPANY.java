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
@Entity(name = "company")
public class COMPANY {
	//https://wikidocs.net/161165
	@Id
	private String cpName;
	
	@Column(columnDefinition = "LONGTEXT")
	private String cpUrl;
	
	private int empNum;
	
	@Column
	private int profit;
	@Column
	private int stable;
	@Column
	private int grow;
	@Column
	private int pay;
	
	@Column(columnDefinition = "LONGTEXT")
	private String culture;
	@Column(columnDefinition = "LONGTEXT")
	private String cpImg;
}
