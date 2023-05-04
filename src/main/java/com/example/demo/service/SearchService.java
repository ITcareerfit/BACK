package com.example.demo.service;

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
import com.example.demo.dto.PostDtoWithInt;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@RequiredArgsConstructor
@Service

public class SearchService {
    public final PostRepository postRepository;
    public final CompanyRepository companyRepository;
    
    //페이징 처리
    public Page<PostDto> findAll(Pageable pageable){
    	//dead 처리 진행
    	Page<POST> posts = postRepository.findNonDead(pageable);
    	List<PostDto> postDtos = new ArrayList<>();
    	
    	for(POST post: posts) {
    		PostDto postDto = new PostDto();
    		postDto.setInfoId(post.getInfoId());
    		postDto.setInfoCpName(post.getInfoCpName());
    		postDto.setTitle(post.getTitle());
    		postDto.setDeadline(post.getDeadline());
    		postDto.setType(post.getType());
    		postDto.setInfoPos(post.getInfoPos());
    		postDto.setInfoTech(post.getInfoTech());
    		//postDto.setInfoPosList(post.getInfoPosList());
    		//postDto.setInfoTechList(post.getInfoTechList());
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
    public Page<PostDto> findfilterAll(Pageable pageable, JobDto jobDto) {
		// jobDto에서 필요한 정보 추출
		String company = jobDto.getCompany();
		String jobType = jobDto.getJobType();
		int employee = jobDto.getEmployee();
		int pay = jobDto.getPay();
		int career = jobDto.getCareer();
		List<String> jobList = jobDto.getJob();
		List<String> stackList = jobDto.getStack();
			    
		//필터링
		Page<POST> posts = postRepository.findPostFilterPageing(pageable, company, jobType, employee, pay, career, jobList, stackList);
		//Page<POST> posts = postRepository.findNonDead(pageable);
    	List<PostDto> postDtos = new ArrayList<>();
    	
    	for(POST post: posts) {
    		PostDto postDto = new PostDto();
    		postDto.setInfoId(post.getInfoId());
    		postDto.setInfoCpName(post.getInfoCpName());
    		postDto.setTitle(post.getTitle());
    		postDto.setDeadline(post.getDeadline());
    		postDto.setType(post.getType());
    		postDto.setInfoPosList(post.getInfoPosList());
    		postDto.setInfoTechList(post.getInfoTechList());
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

	
	//post에 있는 string pos, tech -> list로 변환
	public void listToString() {
		List<POST> posts = postRepository.findAll();
    	
    	for(POST post: posts) {
	        List<String> listPos = getListFromString(post.getInfoPos());
	        post.setInfoPosList(listPos);
	        List<String> listTech = getListFromString(post.getInfoTech());
    		post.setInfoTechList(listTech);
    		
    		postRepository.save(post);
    	}	
	}
	
	private List<String> getListFromString(String str) {
	    List<String> list = new ArrayList<>();
	    if (str != null) {
	        str = str.replaceAll("[\\[\\]']", "");
	        String[] arr = str.split(", ");
	        for (String s : arr) {
	            list.add(s);
	        }
	    }
	    return list;
	}
    
    
    public long conutInfos() {
    	return postRepository.count();
    }

	public POST findPostId(int infoId) {
		return postRepository.findByInfoId(infoId);
	}
	
    
    
    /*
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
    		//postDto.setInfoPos(post.getInfoPos());
    		//postDto.setInfoTech(post.getInfoTech());
    		
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
    }*/
    

	/*
	//필터링 페이지
	public PostDtoWithInt PostsByFilters(JobDto jobDto, int page, int size) {
	    // jobDto에서 필요한 정보 추출
		String company = jobDto.getCompany();
	    String jobType = jobDto.getJobType();
	    int employee = jobDto.getEmployee();
	    int pay = jobDto.getPay();
	    int career = jobDto.getCareer();
	    List<String> jobList = jobDto.getJob();
	    List<String> stackList = jobDto.getStack();
	    
	    // 1차 필터링
	    List<POST> posts = postRepository.findPostsByFilter(company, jobType, employee, pay, career);
	    //List<POST> posts = postRepository.findAll();
	    List<PostDto> postDtos = new ArrayList<>();

	    for (POST post : posts) {
	    	PostDto postDto = new PostDto();
	    	
    		postDto.setInfoId(post.getInfoId());
    		Integer infoId = post.getInfoId();
    		POST post_cp_name = postRepository.findByInfoId(infoId);
    		postDto.setInfoCpName(post_cp_name.getInfoCpName());
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
	    
	    // postDtos 리스트의 크기 반환
	    int totalPostCount = postDtos.size();
	    
	    // paging 처리
	    int startIndex = (page-1) * size;
	    int endIndex = Math.min(startIndex + size, postDtos.size());
	    List<PostDto> pagedPostDtos = postDtos.subList(startIndex, endIndex);
	    //전체 포스트 개수와 paging 처리된 포스트 목록 반환
	    return new PostDtoWithInt(pagedPostDtos, totalPostCount);
	    //return postDtos.subList(startIndex, endIndex);
	}
	 */
	
	/*
	private boolean isFilteredByPos(String infoPos, List<String> jobList) {
	    if (jobList == null || jobList.isEmpty()) {
	        return false;
	    }

	    List<String> listPos = getListFromString(infoPos);
	    for (String list : listPos) {
	        for (String jobListElement : jobList) {
	            if (list.equals(jobListElement)) {
	                return false;
	            }
	        }
	    }
	    return true;
	}

	private boolean isFilteredByTech(String infoTech, List<String> stackList) {
	    if (stackList == null || stackList.isEmpty()) {
	        return false;
	    }

	    List<String> listTech = getListFromString(infoTech);
	    for (String list : listTech) {
	        for (String stackListElement : stackList) {
	            if (list.equals(stackListElement)) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
*/
	
	/*
	 * //상세보기 public Board detail(int idx) { return
	 * boardRepository.findById(idx).orElse(null); } //수정 public void update(Board
	 * board) { boardRepository.save(board); } //삭제 public void delete(int idx) {
	 * boardRepository.deleteById(idx); }
	 */
}