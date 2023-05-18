package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.COMPANY;
import com.example.demo.domain.POST;
import com.example.demo.domain.TECHNICAL_STACK;

//https://geonoo.tistory.com/149
//jpa 사용법+sql문 받아옴
public interface Technical_StackRepository extends JpaRepository<TECHNICAL_STACK, String> {

	List<TECHNICAL_STACK> findByYear(int i);

	@Query(value = "SELECT t.tech_name, t.month, t.tech_type, t.year, t.total, t.pos_name "
			+ "FROM technical_stack t "
			+ "where month = :month and year = :year "
			+ "and tech_type = 0 "
			+ "order by total desc limit 5 ", nativeQuery = true)
	List<TECHNICAL_STACK> findTopSix(@Param("year")int year, @Param("month")int month);

	@Query(value = "SELECT sum(subquery.total)"
			+ "FROM(SELECT t.total "
			+ "FROM technical_stack t "
			+ "where month = :month and year = :year and tech_type = 0 "
			+ "order by t.total desc "
			+ "LIMIT 18446744073709551615 OFFSET 5 ) as subquery ", nativeQuery = true)
	int findEtc(@Param("year")int year, @Param("month")int month);

	@Query(value = "SELECT sum(t.total) "
			+ "FROM technical_stack t "
			+ "where month = :month and year = :year and tech_type = 0 ", nativeQuery = true)
	int findTotalMonth(@Param("year")int year, @Param("month")int month);
	
}