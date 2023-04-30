package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.domain.POST;
import com.example.demo.domain.COMPANY;
import com.example.demo.dto.JobDto;
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
    public final CompanyRepository companyRepository;
    
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

	public List<PostDto> PostsByFilter(JobDto jobDto) {
		String company = jobDto.getCompany();
		//COMPANY cp_name = companyRepository.findByCpName(company);
	    String jobType = jobDto.getJobType();
	    int employee = jobDto.getEmployee();
	    int pay = jobDto.getPay();
	    int career = jobDto.getCareer();
	    List<String> jobList = jobDto.getJob();
	    List<String> stackList = jobDto.getStack();
	    
	    System.out.println(company);
	    
	    List<POST> posts = postRepository.findPostsByFilter(company, jobType, employee, pay, career);
    	//Page<POST> posts = postRepository.findAll(pageable);
    	List<PostDto> postDtos = new ArrayList<>();
	    
    	for(POST post: posts) {
    		PostDto postDto = new PostDto();
    		
      		String strPos = post.getInfoPos();
    		List<String> listPos = new ArrayList<>();
    		if(strPos != null) {
    			strPos = strPos.replaceAll("[\\[\\]']", ""); // 작은 따옴표와 대괄호 제거
        		String[] arr = strPos.split(", "); // 쉼표와 공백을 기준으로 분리
        		for (String s : arr) {listPos.add(s);}
    		}
    		
    		String strTech = post.getInfoTech();
    		List<String> listTech = new ArrayList<>();
    		if(strTech != null) {
    			strTech = strTech.replaceAll("[\\[\\]']", "");
        		String[] arr = strTech.split(", ");
        		for (String s : arr) {listTech.add(s);}
    		}
    		
    		boolean flag = false;
    		if(jobList != null && !jobList.isEmpty()) {
    			flag = true;
        		for(String list: listPos) {
        			for(String job_list : jobList) {
        				if(list.equals(job_list)) { 
        					flag = false;
        					continue;
        				}
        			}
        		}
    		}
    		if(flag) continue;
    		
    		flag = false;
    		if(stackList != null && !stackList.isEmpty()) {
    			flag = true;
        		for(String list: listTech) {
        			for(String stack_list : stackList) {
        				if(list.equals(stack_list)) {
        					flag = false;
        					continue;
        				}
        			}
        		}
        	}
    		if(flag) continue;
    		
    		postDto.setInfoPos(listPos);
    		postDto.setInfoTech(listTech);
  
    		
    		postDto.setInfoId(post.getInfoId());
    		Integer infoId = post.getInfoId();
    		POST post_cp_name = postRepository.findByInfoId(infoId);
    		postDto.setInfoCpName(post_cp_name.getInfoCpName());
    		//postDto.setInfoCpName(cp_name);
    		postDto.setTitle(post.getTitle());
    		postDto.setDeadline(post.getDeadline());
    		postDto.setType(post.getType());
  
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
		//return postRepository.findPostsByFilter(jobList, stackList, company, jobType, employee, pay, career);
	}

    
    
	/*
	 * //상세보기 public Board detail(int idx) { return
	 * boardRepository.findById(idx).orElse(null); } //수정 public void update(Board
	 * board) { boardRepository.save(board); } //삭제 public void delete(int idx) {
	 * boardRepository.deleteById(idx); }
	 */
}