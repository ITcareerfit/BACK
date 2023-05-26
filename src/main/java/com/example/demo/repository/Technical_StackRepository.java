package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.COMPANY;
import com.example.demo.domain.POSITIONS;
import com.example.demo.domain.POST;
import com.example.demo.domain.TECHNICAL_STACK;

//https://geonoo.tistory.com/149
//jpa 사용법+sql문 받아옴
public interface Technical_StackRepository extends JpaRepository<TECHNICAL_STACK, String> {

	@Query(value = "SELECT t.tech_name, t.month, t.tech_type, t.year, t.total, t.pos_name "
			+ "FROM technical_stack t "
			+ "where year = :year "
			+ "and tech_type = 1 "
			+ "and pos_name = ''", nativeQuery = true)
	List<TECHNICAL_STACK> findByYear(@Param("year")int year);

	@Query(value = "SELECT t.tech_name, t.month, t.tech_type, t.year, t.total, t.pos_name "
			+ "FROM technical_stack t "
			+ "where month = :month and year = :year "
			+ "and tech_type = 0 "
			+ "and pos_name = ''"
			+ "order by total desc limit 5 ", nativeQuery = true)
	List<TECHNICAL_STACK> findTopSix(@Param("year")int year, @Param("month")int month);

	@Query(value = "SELECT sum(subquery.total)"
			+ "FROM(SELECT t.total "
			+ "FROM technical_stack t "
			+ "where month = :month and year = :year and tech_type = 0 "
			+ "and pos_name = ''"
			+ "order by t.total desc "
			+ "LIMIT 18446744073709551615 OFFSET 5 ) as subquery ", nativeQuery = true)
	int findEtc(@Param("year")int year, @Param("month")int month);

	@Query(value = "SELECT sum(t.total) "
			+ "FROM technical_stack t "
			+ "where month = :month and year = :year and tech_type = 0 "
			+ "and pos_name = ''", nativeQuery = true)
	int findTotalMonth(@Param("year")int year, @Param("month")int month);

	//각 직군별 최상위 스택 달마다 total 정보 보내주는 쿼리
	@Query(value = "SELECT t.tech_name, t.month, t.tech_type, t.year, t.total, t.pos_name "
			+ "FROM itcareerfit.technical_stack t "
			+ "JOIN ( "
			+ "    SELECT tech_name, SUM(total) AS sumtotal "
			+ "    FROM itcareerfit.technical_stack "
			+ "    WHERE tech_type = 1 AND month <= :month AND year = :year AND pos_name = :job "
			+ "    GROUP BY tech_name "
			+ "    ORDER BY sumtotal DESC "
			+ "    LIMIT 3 "
			+ ") t2 ON t.tech_name = t2.tech_name "
			+ "where tech_type = 1 AND month <= :month AND year = :year AND pos_name = :job ", nativeQuery = true)
	List<TECHNICAL_STACK> findStacks(@Param("job")String job, @Param("year")int year, @Param("month")int month);
}