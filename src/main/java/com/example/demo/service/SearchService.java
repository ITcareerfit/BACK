package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PostRepository;
import com.example.demo.domain.POST;
import com.example.demo.dto.PostDto;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class SearchService {
    public final PostRepository postRepository;
    
    //목록, 전체 노출
    public List<PostDto> findAll(){
    	List<POST> posts = postRepository.findAll();
    	List<PostDto> postDtos = new ArrayList<>();
    	
    	for(POST post: posts) {
    		PostDto postDto = new PostDto();
    		postDto.setInfoId(post.getInfoId());
    		postDto.setInfoCpName(post.getInfoCpName());
    		postDto.setTitle(post.getTitle());
    		postDto.setDeadline(post.getDeadline());
    		postDto.setType(post.getType());
  
    		//string -> list, 작은 따옴표(')로 감싸져 있으므로, 작은 따옴표를 제거하고 값을 추출
    		String strPos = post.getInfoPos();
    		List<String> listPos = new ArrayList<>();
    		if(strPos != null) {
    			strPos = strPos.replaceAll("[\\[\\]']", ""); // 작은 따옴표와 대괄호 제거
        		String[] arr = strPos.split(", "); // 쉼표와 공백을 기준으로 분리
        		for (String s : arr) {listPos.add(s);}
    		}
    		//System.out.println(listPos);
    		postDto.setInfoPos(listPos);
    		
    		String strTech = post.getInfoTech();
    		List<String> listTech = new ArrayList<>();
    		if(strTech != null) {
    			strTech = strTech.replaceAll("[\\[\\]']", "");
        		String[] arr = strTech.split(", ");
        		for (String s : arr) {listTech.add(s);}
    		}
    		//System.out.println(listTech);
    		postDto.setInfoTech(listTech);
    		
    		postDto.setInfoLoc(post.getInfoLoc());
    		postDto.setMaxCareer(post.getMaxCareer());
    		postDto.setMinCareer(post.getMinCareer());
    		postDto.setMaxPay(post.getMaxPay());
    		postDto.setMinPay(post.getMinPay());
    		postDto.setInfoUrl(post.getInfoUrl());
    		postDto.setContent(post.getContent());
    		
    		postDtos.add(postDto);
    	}
    	
    	return postDtos;
    }
    
    //페이징 처리
    public Page<PostDto> findAll(Pageable pageable){
    	Page<POST> posts = postRepository.findNonDead(pageable);
    	//Page<POST> posts = postRepository.findAll(pageable);
    	List<PostDto> postDtos = new ArrayList<>();
    	
    	for(POST post: posts) {
    		PostDto postDto = new PostDto();
    		postDto.setInfoId(post.getInfoId());
    		postDto.setInfoCpName(post.getInfoCpName());
    		postDto.setTitle(post.getTitle());
    		postDto.setDeadline(post.getDeadline());
    		postDto.setType(post.getType());
  
    		//string -> list, 작은 따옴표(')로 감싸져 있으므로, 작은 따옴표를 제거하고 값을 추출
    		String strPos = post.getInfoPos();
    		List<String> listPos = new ArrayList<>();
    		if(strPos != null) {
    			strPos = strPos.replaceAll("[\\[\\]']", ""); // 작은 따옴표와 대괄호 제거
        		String[] arr = strPos.split(", "); // 쉼표와 공백을 기준으로 분리
        		for (String s : arr) {listPos.add(s);}
    		}
    		postDto.setInfoPos(listPos);
    		
    		String strTech = post.getInfoTech();
    		List<String> listTech = new ArrayList<>();
    		if(strTech != null) {
    			strTech = strTech.replaceAll("[\\[\\]']", "");
        		String[] arr = strTech.split(", ");
        		for (String s : arr) {listTech.add(s);}
    		}
    		postDto.setInfoTech(listTech);
    		postDto.setInfoLoc(post.getInfoLoc());
    		postDto.setMaxCareer(post.getMaxCareer());
    		postDto.setMinCareer(post.getMinCareer());
    		postDto.setMaxPay(post.getMaxPay());
    		postDto.setMinPay(post.getMinPay());
    		postDto.setInfoUrl(post.getInfoUrl());
    		postDto.setContent(post.getContent());
    		
    		postDtos.add(postDto);
    	}
  
    	return new PageImpl<>(postDtos, pageable, posts.getTotalElements());
    }
    
    public long conutInfos() {
    	return postRepository.count();
    }

	public POST findPostId(int infoId) {
		
		return postRepository.findByInfoId(infoId);
	}

    
    
	/*
	 * //상세보기 public Board detail(int idx) { return
	 * boardRepository.findById(idx).orElse(null); } //수정 public void update(Board
	 * board) { boardRepository.save(board); } //삭제 public void delete(int idx) {
	 * boardRepository.deleteById(idx); }
	 */
}