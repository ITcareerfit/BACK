package com.example.demo.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.example.demo.domain.COMPANY;
import com.example.demo.domain.USER;
import com.example.demo.dto.PostDto;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.SignUpService;

import lombok.RequiredArgsConstructor;

@RestController
@Controller
@RequestMapping("/value")
@RequiredArgsConstructor
public class ValueController {
	
}
