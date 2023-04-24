//
//package com.example.demo.controller;
//
//import java.util.Map;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/login")
////@RequiredArgsConstructor
//public class TestController {
//	@PostMapping("/test")
//	@CrossOrigin(origins = "*", allowedHeaders = "*")
//	public String getTest(@RequestBody Map<String, String> requestData) {
//		requestData.forEach((key, value) -> {
//            System.out.println("key : " + key);
//            System.out.println("value : " + value);
//        });
//		return "yes";
//		//return "{\"response\": \"yes\"}";
//	}
//}

