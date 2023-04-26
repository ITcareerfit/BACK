/*
 * package com.example.demo.controller;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.demo.domain.USER; import
 * com.example.demo.service.SignUpService;
 * 
 * import lombok.RequiredArgsConstructor;
 * 
 * @RestController
 * 
 * @Controller
 * 
 * @RequestMapping("/login")
 * 
 * @RequiredArgsConstructor public class LoginController { private final
 * SignUpService signupservice;
 * 
 * @PostMapping("/test")
 * 
 * @CrossOrigin(origins = "http://172.16.54.57:3000")//react서버 통신
 * //https://studyandlearn.tistory.com/m/388 public @ResponseBody
 * ResponseEntity<?> handlePostRequest(@RequestBody Map request) { // 요청 파라미터 처리
 * String email = (String) request.get("email"); String pw =
 * (String)request.get("pw");
 * 
 * boolean flag = signupservice.checkUser(email, pw);
 * 
 * Map<String, Object> result = new HashMap<>(); if(flag) { USER user =
 * signupservice.detail(email); result.put("message", "success");
 * result.put("user", user); return ResponseEntity.ok(result); } else {
 * result.put("message", "fail"); return ResponseEntity.ok(result); } } }
 */