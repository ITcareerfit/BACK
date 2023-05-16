package com.example.demo.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor // jpa 필수
@AllArgsConstructor
@ToString
@Entity(name = "technical_stack")
@Data
@IdClass(techPK.class)
public class TECHNICAL_STACK {
	
	//https://wikidocs.net/161165
	@Id
	private String techName;
	@Id
    private int year;
	@Id
    private int month;
	
	@Column(nullable = false)
	private int techType;
	@Column(columnDefinition = "int default 0")
	private int total;
}
