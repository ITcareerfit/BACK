package com.example.demo.controller;

import java.time.LocalDate;
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

import com.example.demo.domain.POST;
import com.example.demo.dto.PostDto;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.SearchService;
import com.example.demo.service.SignUpService;

import lombok.RequiredArgsConstructor;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/info")
public class InfoController {
	private final SearchService searchservice;
	private final SignUpService signupservice;
	
	@GetMapping
	//info 노출
	public ResponseEntity<POST> createUser(
			@RequestParam int infoId) {
		POST post = searchservice.findPostId(infoId);
		
		return new ResponseEntity<>(post, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<List<Integer>> GoodPostSend(
			@RequestParam int infoId,
			@RequestBody Map<String, Integer> request ) {
	    Integer userNumObj = request.get("userNum");
	    //Integer infoIdObj = request.get("infoId");
	    Integer flagObj = request.get("flag");

	    if (userNumObj == null || flagObj == null) {
	    	System.out.println("no");
	        return ResponseEntity.badRequest().build();
	    }

	    int userNum = userNumObj.intValue();
	    //int infoId = infoIdObj.intValue();
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
}
