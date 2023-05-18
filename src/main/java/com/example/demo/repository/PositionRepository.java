package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.POSITIONS;

//https://geonoo.tistory.com/149
//jpa 사용법+sql문 받아옴
public interface PositionRepository extends JpaRepository<POSITIONS, String> {

	@Query(value = "SELECT p.pos_name, p.month, p.year, p.total "
			+ "FROM positions p "
			+ "where month between 0 and :month "
			+ "and year = :year "
			+ "and pos_name = :pos_name ", nativeQuery = true)
	List<POSITIONS> findPosInfo(@Param("pos_name")String pos_name, @Param("year")int year, @Param("month")int month);

	@Query(value = "SELECT p.pos_name, p.month, p.year, p.total "
			+ "FROM positions p "
			+ "where month = :month "
			+ "and year = :year "
			+ "and (pos_name = :pos_name_1 or pos_name = :pos_name_2 or pos_name = :pos_name_3) "
			+ "order by total desc limit 1 ", nativeQuery = true)
	POSITIONS findTopJob(@Param("pos_name_1")String pos_name_1, @Param("pos_name_2")String pos_name_2, @Param("pos_name_3")String pos_name_3,
			@Param("year")int year, @Param("month")int month);

}