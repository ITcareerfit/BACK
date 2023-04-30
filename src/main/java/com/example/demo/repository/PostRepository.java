package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.POST;

//https://geonoo.tistory.com/149
//jpa 사용법+sql문 받아옴
public interface PostRepository extends JpaRepository<POST, Integer> {
	long count();
	//현재 공고가 살아있는지 확인하는 쿼리
	//엔티티의 필드명을 이용하여 SQL을 생성하기 때문에, 엔티티의 필드명에 맞춰서 JPQL 쿼리를 작성
	@Query("SELECT p FROM post p WHERE p.dead = false") 
	Page<POST> findNonDead(Pageable pageable);
	POST findByInfoId(Integer infoId);
}