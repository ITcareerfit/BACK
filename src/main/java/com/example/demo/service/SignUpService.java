package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

import com.example.demo.domain.USER;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SignUpService {
    public final UserRepository userRepository;

    //등록
    @Transactional
    public void register(USER user) {
    	System.out.println(user.getPos());
    	userRepository.save(user);
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