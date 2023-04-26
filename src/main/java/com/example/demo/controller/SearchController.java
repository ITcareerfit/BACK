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

import com.example.demo.dto.PostDto;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.SearchService;


import lombok.RequiredArgsConstructor;


@RestController
@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
	private final SearchService searchService;
	
	@GetMapping 
	public ResponseEntity<List<PostDto>> findAll(){
		List<PostDto> postDtos = searchService.findAll();
		
		return new ResponseEntity<>(postDtos, HttpStatus.OK);  
	}
	
	
	@GetMapping("/posts")
	//http://localhost:8080/search/posts?page=0&size=14
	public ResponseEntity<Page<PostDto>> findAll(
			@RequestParam int page,
			@RequestParam int size){
		Pageable pageable = PageRequest.of(page, size);
	    Page<PostDto> postDtos = searchService.findAll(pageable);
	    return new ResponseEntity<>(postDtos, HttpStatus.OK);
	}
	   
}
