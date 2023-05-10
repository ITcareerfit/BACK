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
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.ValueService;

import lombok.RequiredArgsConstructor;

@RestController
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
	private final ValueService valueservice;
	
	@GetMapping
	public ResponseEntity<List<PostDto>> createUser(
			@RequestParam String cpName) {
		List<PostDto>postDtos = valueservice.valuecomPosts(cpName);
	    //result.put("message", "no");
		return ResponseEntity.ok(postDtos); 
	}
}
