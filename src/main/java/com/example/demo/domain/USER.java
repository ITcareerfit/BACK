package com.example.demo.domain;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "user")
public class USER {
	//https://wikidocs.net/161165
	@Id
	@Column(nullable = false, length = 45)
	private String email;
	
	@Column(nullable = false, length = 45)
	private String pw;
	
	@Column(nullable = false, length = 45)
	private String userName;
	
	@Column(nullable = false, length = 45)
	private String phone;
	
	@CreationTimestamp
	@Column
	private LocalDate birth;
	
	@Column(columnDefinition = "LONGTEXT")
	private String pos;
	
	@ManyToOne
	@JoinColumn(name="company1", referencedColumnName="cpName")
	private COMPANY company1;
	@ManyToOne
	@JoinColumn(name="company2", referencedColumnName="cpName")
	private COMPANY company2;
	@ManyToOne
	@JoinColumn(name="company3", referencedColumnName="cpName")
	private COMPANY company3;
	@ManyToOne
	@JoinColumn(name="company4", referencedColumnName="cpName")
	private COMPANY company4;
	@ManyToOne
	@JoinColumn(name="company5", referencedColumnName="cpName")
	private COMPANY company5;
	
	@Column(columnDefinition = "LONGTEXT")
	private String goodPosts;
	
	@Column(columnDefinition = "LONGTEXT")
	private String img;
	
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
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userNum;
	
	
}
