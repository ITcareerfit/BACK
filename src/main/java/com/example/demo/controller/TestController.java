package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class TestController {
	
	/*
	 * @GetMapping("/test")
	 * 
	 * @CrossOrigin(origins = "http://172.16.54.57:3000") //@CrossOrigin(origins =
	 * "http://localhost:3000", methods = RequestMethod.GET) public String getTest()
	 * { return "1"; }
	 * 
	 * @PostMapping("/test")
	 * 
	 * @CrossOrigin(origins = "http://172.16.54.57:3000")//react서버 통신
	 * //https://studyandlearn.tistory.com/m/388 public @ResponseBody
	 * ResponseEntity<?> handlePostRequest(@RequestBody Map request) { // 요청 파라미터 처리
	 * String name = (String) request.get("email"); String age = (String)
	 * request.get("pw");
	 * 
	 * //System.out.println(name);
	 * 
	 * // 처리 결과 반환 Map<String, Object> result = new HashMap<>();
	 * result.put("message", "success"); result.put("name", name); result.put("age",
	 * age);
	 * 
	 * return ResponseEntity.ok(result); }
	 */
}
