package com.example.demo.domain;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@Column
	private String cpName;
	
	@Column(columnDefinition = "LONGTEXT")
	private String cpUrl;
	
	private Integer empNum;
	
	@Column
	private Double profit;
	@Column
	private Double stable;
	@Column
	private Double grow;
	@Column
	private Double pay;
	@Column
	private Double scale;
	
	@Column(columnDefinition = "LONGTEXT")
	private String culture;
	@Column(columnDefinition = "LONGTEXT")
	private String cpImg;
}
