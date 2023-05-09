package com.example.demo.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;

import jakarta.persistence.CollectionTable;
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
@Entity(name = "post")
public class POST {
	//https://wikidocs.net/161165
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer infoId;
	
	@ManyToOne
	@JoinColumn(name="info_cp_name", referencedColumnName="cpName")
	private COMPANY infoCpName;
	
	@Column(nullable = false, length = 45)
	private String title;
	
	@Column
	private LocalDate deadline;
	@Column
	private Long dDay;
	private int type;
	@Column(length = 45)
	private String infoLoc;
	
	@Column(columnDefinition = "LONGTEXT")
	private String infoPos;
	@Column(columnDefinition = "LONGTEXT")
	private String infoTech;
    
	@ElementCollection
    @CollectionTable(name = "infoTechList")
    private List<String> infoTechList;
    @ElementCollection
    @CollectionTable(name = "infoPosList")
    private List<String> infoPosList;
    
	@Column(columnDefinition = "int default 0")
	private int minCareer;
	@Column(columnDefinition = "int default 20")
	private int maxCareer;
	@Column(columnDefinition = "int default -1")
	private int minPay;
	@Column(columnDefinition = "int default -1")
	private int maxPay;
	//@Column(columnDefinition = "LONGTEXT")
	//@Column(length = 255)
	//private String infoUrl;
	@Column(columnDefinition = "LONGTEXT")
	private String content;
	 @Column(columnDefinition = "int default 0")
	private int dead;
	private LocalDate lastCheck;
}
