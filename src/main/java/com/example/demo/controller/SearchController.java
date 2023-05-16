package com.example.demo.controller;

import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.COMPANY;
import com.example.demo.domain.POST;
import com.example.demo.domain.USER;
import com.example.demo.domain.TECHNICAL_STACK;
import com.example.demo.dto.JobDto;
import com.example.demo.dto.PostDto;
import com.example.demo.dto.PostDtoWithInt;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.PostRepository;

import com.example.demo.service.SearchService;
import com.example.demo.service.SignUpService;
import com.example.demo.service.Technical_StackService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;

@RestController
@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
	private final SearchService searchService;
	private final Technical_StackService technical_stackservice;
	private final SignUpService signupservice;
	
	/*
	@GetMapping
	public ResponseEntity<Page<PostDto>> findAll(
			@RequestParam int page,
			@RequestParam int size){
		Pageable pageable = PageRequest.of(page-1, size);
	    Page<PostDto> postDtos = searchService.findAll(pageable);
	    return new ResponseEntity<>(postDtos, HttpStatus.OK);
	}*/
	
	//테크 공고 정보들 전송
	@GetMapping
	public ResponseEntity<Map<String, Object>> findAll(
			@RequestParam int page,
			@RequestParam int size){
		Pageable pageable = PageRequest.of(page-1, size);
	    Page<PostDto> postDtos = searchService.findAll(pageable);
	    List<TECHNICAL_STACK> stacks = technical_stackservice.findStacks();
	    
	    Map<String, Object> result = new HashMap<>();
	    
	    result.put("techs", stacks); 
		result.put("postDto", postDtos); 
		return ResponseEntity.ok(result);
	}

	@PostMapping
	public ResponseEntity<PostDtoWithInt> filterPageALL(
			@RequestParam int page,
			@RequestParam int size,
			@RequestBody JobDto jobDto){
	    // jobDto를 사용하여v 포스트를 검색
		//postDto, total 함께 반환
		
		System.out.println(jobDto);
		PostDtoWithInt PDI = searchService.PostsByFilters(jobDto, page, size);
		
		PostDtoWithInt postDtoWithInt = searchService.PostsByFilters(jobDto, page, size);
        return ResponseEntity.ok(postDtoWithInt);
	}
	
	//goodpost 삭제 기능 있어야함, 이친구는 like 있어야 접근 가능
	@PostMapping("like")
	public ResponseEntity<List<Integer>> GoodPostSend(
			@RequestParam int page,
			@RequestParam int size,
			@RequestBody Map<String, Integer> request ) {
	    Integer userNumObj = request.get("userNum");
	    Integer infoIdObj = request.get("infoId");
	    Integer flagObj = request.get("flag");

	    if (userNumObj == null || infoIdObj == null || flagObj == null) {
	    	System.out.println("no");
	        return ResponseEntity.badRequest().build();
	    }

	    int userNum = userNumObj.intValue();
	    int infoId = infoIdObj.intValue();
	    int flag = flagObj.intValue();
	    
		if(flag == 0) {//추가
			List<Integer>gp_list = signupservice.goodPostInsert(userNum, infoId);
			return ResponseEntity.ok(gp_list);
		}
		else if(flag == 1){//삭제
			List<Integer>gp_list = signupservice.goodPostDelete(userNum, infoId);
			return ResponseEntity.ok(gp_list);
		}else return null;
	}
	
	@GetMapping("change")
	public boolean changetojavaSerialization(){
		searchService.listToString();
		
		return true;
	}
	
	/*
	@PostMapping("test")
	public ResponseEntity<Page<PostDto>> filterPaging(
			@RequestParam int page,
			@RequestParam int size,
			@RequestBody JobDto jobDto){
	    
		Pageable pageable = PageRequest.of(page-1, size);
	    Page<PostDto> postDtos = searchService.findfilterAll(pageable, jobDto);
	    return new ResponseEntity<>(postDtos, HttpStatus.OK);
	}*/

	
	/*
	@GetMapping 
	public ResponseEntity<List<PostDto>> findAll(){
		List<PostDto> postDtos = searchService.findAll();
		
		return new ResponseEntity<>(postDtos, HttpStatus.OK);  
	}
	
	@PostMapping("/all")
	public ResponseEntity<Map<String, Object>> filterAll(
			@RequestBody JobDto jobDto){
	    // jobDto를 사용하여 포스트를 검색
		List<PostDto> postDtos = searchService.PostsByFilter(jobDto);
	    //List<PostDto> postDtos = searchService.PostsByFilters(jobDto, (page-1)*size, (page-1)*size + size);
	    
	    Map<String, Object> result = new HashMap<>();
	    if (!postDtos.isEmpty()) {	 
	    	result.put("message", "yes"); 
			result.put("postDtos", postDtos); 
			return ResponseEntity.ok(result);
	    }else {
	    	result.put("message", "no"); 
			return ResponseEntity.ok(result);
	    } 
	}
	*/
}
