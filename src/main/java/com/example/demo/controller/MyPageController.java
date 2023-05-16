package com.example.demo.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//mypage 처음 접근
	@GetMapping("/{userNum}")
	public ResponseEntity<Map<String, Object>> userGoodPostsThree(
			@PathVariable Integer userNum) {
		//gp_list, gp_list_info보내줌-> 3개
		Map<String, Object> result = signupservice.user_GPosts(userNum, 3); 
		return ResponseEntity.ok(result); 
	}
	
	@PostMapping("/{userNum}")//기업 관련 공고
	public ResponseEntity<List<PostDto>> companyallocatedPosts(
			@PathVariable Integer userNum, 
			@RequestParam String cpName) {
		List<PostDto>postDtos = valueservice.valuecomPosts(cpName);
		return ResponseEntity.ok(postDtos); 
	}
	
	//goodpost 삭제 기능 있어야함
	
	//goodpost로 접근시 모든 정보 보냄
	@GetMapping("/{userNum}/goodpost")
	public ResponseEntity<Map<String, Object>> userGoodPostsAll(
			@PathVariable Integer userNum) {
		//gp_list, gp_list_info보내줌
		Map<String, Object> result = signupservice.user_GPosts(userNum, 0); 
		return ResponseEntity.ok(result);
	}
	
	//사실 삭제만 가능
	@PostMapping("/{userNum}/goodpost")
	public ResponseEntity<List<Integer>> GoodPostSend(
			@PathVariable Integer userNum,
			@RequestBody Map<String, Integer> request ) {
	    //Integer userNumObj = request.get("userNum");
	    Integer infoIdObj = request.get("infoId");
	    Integer flagObj = request.get("flag");

	    if (infoIdObj == null || flagObj == null) {
	    	System.out.println("no");
	        return ResponseEntity.badRequest().build();
	    }

	    int usernum = userNum.intValue();
	    int infoId = infoIdObj.intValue();
	    int flag = flagObj.intValue();
	    
		if(flag == 0) {//추가
			List<Integer>gp_list = signupservice.goodPostInsert(usernum, infoId);
			return ResponseEntity.ok(gp_list);
		}
		else if(flag == 1){//삭제
			List<Integer>gp_list = signupservice.goodPostDelete(usernum, infoId);
			return ResponseEntity.ok(gp_list);
		}else return null;
	}
	
}











