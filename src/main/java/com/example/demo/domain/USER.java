package com.example.demo.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

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
@Entity
@Table(name = "user", uniqueConstraints = {
	    @UniqueConstraint(name = "user_num", columnNames = "user_num")
	})
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
	
	//list로 들어오는 값 스트링으로 저장
	/*
	 * @Column(columnDefinition = "LONGTEXT") private List<String> pos;
	 */
    @ElementCollection
    @CollectionTable(name = "pos")
    private List<String> pos;
	
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
	
	//@Column(columnDefinition = "LONGTEXT")
	@ElementCollection
    @CollectionTable(name = "goodPosts")
	private List<Integer> goodPosts;
	
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
	@Column(name = "user_num", nullable =false, unique = true)
	private int userNum;
	//MySQL에서는 INT, BIGINT, SMALLINT 등의 정수형 데이터 타입에서 auto increment를 지원
}
