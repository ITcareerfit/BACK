package com.example.demo.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.COMPANY;
import com.example.demo.domain.USER;
import com.example.demo.dto.PostDto;
import com.example.demo.dto.ValueDto;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.ValueService;
import com.example.demo.service.SignUpService;

import lombok.RequiredArgsConstructor;

@RestController
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
	private final ValueService valueservice;
	private final SignUpService signupservice;
	
	@GetMapping
	public ResponseEntity<List<PostDto>> createUser(
			@RequestParam String cpName) {
		List<PostDto>postDtos = valueservice.valuecomPosts(cpName);
	    //result.put("message", "no");
		return ResponseEntity.ok(postDtos); 
	}
	
	@PostMapping
	public ResponseEntity<List<PostDto>> GoodPostSend(
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
			List<PostDto>postDtos = signupservice.goodPostInsert(userNum, infoId);
			return ResponseEntity.ok(postDtos);
		}
		else if(flag == 1){//삭제
			List<PostDto>postDtos = signupservice.goodPostDelete(userNum, infoId);
			return ResponseEntity.ok(postDtos);
		}else return null;
	}
	
}











