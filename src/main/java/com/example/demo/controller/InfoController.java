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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.POST;
import com.example.demo.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/info")
public class InfoController {
	private final SearchService searchservice;
	
	@GetMapping
	//info 노출
	public ResponseEntity<POST> createUser(
			@RequestParam int infoId) {
		POST post = searchservice.findPostId(infoId);
		
		return new ResponseEntity<>(post, HttpStatus.OK); 
	}
}
