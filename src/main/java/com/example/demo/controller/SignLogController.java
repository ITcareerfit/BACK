package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.USER;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SignUpService;

import lombok.RequiredArgsConstructor;

@RestController
@Controller
@RequiredArgsConstructor
public class SignLogController {
	private final SignUpService signupservice;
	/*
	 * @GetMapping("/signup")
	 * 
	 * @CrossOrigin(origins = "http://172.16.54.57:3000") //@CrossOrigin(origins =
	 * "http://localhost:3000", methods = RequestMethod.GET) public String getTest()
	 * { return "1"; }
	 */

	
	//회원가입
	@PostMapping("/signup")
	@CrossOrigin(origins = "http://172.16.54.57:3000")//react서버 통신
	public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto userDto) {
	    USER user = new USER();
	    user.setEmail(userDto.getEmail());
	    user.setPw(userDto.getPw());
	    user.setUserName(userDto.getUserName());
	    user.setBirth(userDto.getBirth());
	    user.setPhone(userDto.getPhone());
	    // userDto에서 pos 정보 가져오기
	    List<String> pos = userDto.getPos();
	    //List<String> posList = Arrays.asList("developer", "designer", "manager");
	    user.setPos(pos);	 
	    
	    //회원가입
	    signupservice.register(user);
	    
	    	//처리 결과 반환 
		Map<String, Object> result = new HashMap<>();
		result.put("message", "success"); 
		result.put("user", user); 
		return ResponseEntity.ok(result); 
	}

	
	
	
	
	/*
	  @PostMapping("/signup")
	  @CrossOrigin(origins = "http://172.16.54.57:3000")//react서버 통신
	  //https://studyandlearn.tistory.com/m/388 public @ResponseBody
	  ResponseEntity<?> handlePostRequest(@RequestBody Map<String, String> request){ // 요청 파라미터 처리 
		  String email = request.get("email"); 
		  String pw = request.get("pw"); 
		  String userName = request.get("userName"); 
		  LocalDate birth = LocalDate.now(); 
		  String phone = request.get("phone");
	  	  //string 형태로 저장
	  
		  //System.out.println(name);
	  
		  //USER 객체 생성 및 값 설정 
		  USER user = new USER(); 
		  user.setEmail(email);
		  user.setPw(pw); 
		  user.setUserName(userName); 
		  user.setBirth(birth);
		  user.setPhone(phone);
	  
		  // 회원가입 처리 
		  signupservice.register(user);
	  
		  //처리 결과 반환 
		  Map<String, Object> result = new HashMap<>();
		  result.put("message", "success"); 
		  result.put("user", user); 
		  return ResponseEntity.ok(result); 
	}*/
	 
	
	//로그인
	@PostMapping("/login")
	@CrossOrigin(origins = "http://172.16.54.57:3000")//react서버 통신
	//같은 handlePostRequest가 있을 경우에는 둘이 이름을 바꿔줘야한다.
	//ex) handlePostRequestWithStringValues, handlePostRequestWithIntegerValues
	ResponseEntity<?> handlePostRequestWithStringValues(@RequestBody Map<String, Object> request) { // 요청 파라미터 처리
		String email = (String) request.get("email"); 
		String pw = (String)request.get("pw");
		
		boolean flag = signupservice.checkUser(email, pw);
		
		Map<String, Object> result = new HashMap<>();
		if(flag) {
			USER user = signupservice.detail(email);
		    result.put("message", "success");
		    result.put("user", user);
		    return ResponseEntity.ok(result); 
		}
		else {
			result.put("message", "fail");
		    return ResponseEntity.ok(result);	
		}	  
	}
}
