package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.TECHNICAL_STACK;
import com.example.demo.domain.POSITIONS;
import com.example.demo.service.Technical_StackService;

import lombok.RequiredArgsConstructor;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/trend")
public class TrendController {
	private final Technical_StackService technical_stackservice;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> findTrendbyGet(
			@RequestParam int year, int month ) {
	    List<String> jobList = new ArrayList<>();
	    //["프론트엔드","ios","서버/백엔드"]
	    jobList.add("서버/백엔드");
	    jobList.add("ios");
	    jobList.add("프론트엔드");
	    String job = "서버/백엔드";
		
	    //1번 트랜드 언어별 분석
	    Map<String, Object> top_lan =technical_stackservice.findTopSixLan(year, month);  
	    
	    //2번 직무별 분석
	    Map<String, Object> three_jobs =technical_stackservice.findThreePos(year, month, jobList);
	    
	    //3번 직무별 프레임워크 분석
	    //Map<String, Object> three_stacks =technical_stackservice.findThreeStack(year, month, jobList);
	    
	    Map<String, Object> result = new HashMap<>();
	     
		result.put("trend1", top_lan); 
		result.put("trend2", three_jobs); 
		return ResponseEntity.ok(result);
	}
	
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> findTrendbyPost(
			@RequestBody Map<String, Object> request ) {
	    Integer yearObj = (Integer)request.get("year");
	    Integer monthObj = (Integer)request.get("month");
	    List<String> jobList = (List<String>)request.get("jobList");
	    String job = (String)request.get("jobTypeTrend");
		
	    //System.out.println(jobList.get(0));
	    
	    int year = yearObj.intValue();
	    int month = monthObj.intValue();
	    
	    //1번 트랜드 언어별 분석
	    Map<String, Object> top_lan =technical_stackservice.findTopSixLan(year, month);  
	    
	    //2번 직무별 분석
	    Map<String, Object> three_jobs =technical_stackservice.findThreePos(year, month, jobList);
	    
	    //3번
	    Map<String, Object> three_stacks =technical_stackservice.findThreeStacks(year, month, job);
	    
	    Map<String, Object> result = new HashMap<>();
	     
		result.put("trend1", top_lan); 
		result.put("trend2", three_jobs);
		result.put("trend3", three_stacks);
		return ResponseEntity.ok(result);
	}
	

}
