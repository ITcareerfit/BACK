package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.COMPANY;
import com.example.demo.domain.USER;

//https://geonoo.tistory.com/149
//jpa 사용법+sql문 받아옴
public interface CompanyRepository extends JpaRepository<COMPANY, String> {
	COMPANY findByCpName(String companyName);
}