package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

import com.example.demo.domain.COMPANY;
import com.example.demo.domain.POST;
import com.example.demo.domain.USER;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SignUpService {
    private final UserRepository userRepository;

    //등록
    @Transactional
    public USER register(USER user) {
    	System.out.println(user.getPos());
    	userRepository.save(user);
    	
    	if(userRepository.existsById(user.getEmail())) {
    		return user;
    	}else return null;
    	
    }
    public boolean checkUser(String email, String pw) {
        Optional<USER> userOpt = userRepository.findByEmailAndPw(email, pw);
        if(userOpt.isPresent()) {
            return true; // 조회한 정보가 있으면 true 반환
        }
        return false; // 조회한 정보가 없으면 false 반환
    }
    public USER detail(String email) {
    	return userRepository.findByEmail(email).orElse(null);
    }
    //기업정보, 기업 채용 정보
	public List<COMPANY> findUserCompany(int usernum) {
		USER user = new USER();
		user = userRepository.findByUserNum(usernum);
		
		List<COMPANY> usercompanys = new ArrayList<>();
		usercompanys.add(user.getCompany1());
		usercompanys.add(user.getCompany2());
		usercompanys.add(user.getCompany3());
		usercompanys.add(user.getCompany4());
		usercompanys.add(user.getCompany5());
		
		
		return usercompanys;
	}
    
    /*//상세보기
    public USER detail(String email) {
    	return userRepository.findById(email).orElse(null);
    }
    
    //목록
    public List<Board> list(){
    	return userRepository.findAll(Sort.by(Sort.Direction.ASC, "idx"));
    }
    //수정
    public void update(Board board) {
    	userRepository.save(board);
    }
    //삭제
    public void delete(int idx) {
    	userRepository.deleteById(idx);
    }*/
}