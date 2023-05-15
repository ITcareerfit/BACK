package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

import com.example.demo.domain.COMPANY;
import com.example.demo.domain.POST;
import com.example.demo.domain.USER;
import com.example.demo.dto.PostDto;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SignUpService {
    private final UserRepository userRepository;
    public final PostRepository postRepository;

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
	
	//user좋아요 기능 추가
	public List<PostDto> goodPostInsert(int userNum, int infoId) {
		USER user = userRepository.findByUserNum(userNum);
		
		List<Integer>GPost = user.getGoodPosts();
		if (GPost == null) {//NullPointerException 오류 발생하여 추가
		    GPost = new ArrayList<Integer>();
		}
		GPost.add(infoId);
		user.setGoodPosts(GPost);
		userRepository.save(user);
		
		List<PostDto> postDtos = new ArrayList<>();
		
		for(int id : GPost) {
			POST post = postRepository.findByInfoId(id);
    		PostDto postDto = new PostDto();
    		
    		postDto.setInfoId(post.getInfoId());
    		postDto.setInfoCpName(post.getInfoCpName());
    		postDto.setTitle(post.getTitle());
    		postDto.setDeadline(post.getDeadline());
    		postDto.setType(post.getType());
    		postDto.setDDay(post.getDDay());
    		postDto.setInfoPos(post.getInfoPos());
    		postDto.setInfoTech(post.getInfoTech());
    		postDto.setInfoPosList(post.getInfoPosList());
    		postDto.setInfoTechList(post.getInfoTechList());
    		postDto.setInfoLoc(post.getInfoLoc());
    		postDto.setMaxCareer(post.getMaxCareer());
    		postDto.setMinCareer(post.getMinCareer());
    		postDto.setMaxPay(post.getMaxPay());
    		postDto.setMinPay(post.getMinPay());
    		postDto.setContent(post.getContent());

    		postDtos.add(postDto);
		}
		
		return postDtos;
	}

	//user좋아요 기능 삭제
	public List<PostDto> goodPostDelete(int userNum, int infoId) {
		USER user = userRepository.findByUserNum(userNum);
		
		List<Integer>GPost = user.getGoodPosts();
		int idx = GPost.indexOf(infoId);//특정문자의 index 찾기
		System.out.println(idx);
		GPost.remove(idx);
		System.out.println(GPost);
		user.setGoodPosts(GPost);
		userRepository.save(user);
		
		List<PostDto> postDtos = new ArrayList<>();
		
		for(int id : GPost) {
			POST post = postRepository.findByInfoId(id);
    		PostDto postDto = new PostDto();
    		
    		postDto.setInfoId(post.getInfoId());
    		postDto.setInfoCpName(post.getInfoCpName());
    		postDto.setTitle(post.getTitle());
    		postDto.setDeadline(post.getDeadline());
    		postDto.setType(post.getType());
    		postDto.setDDay(post.getDDay());
    		postDto.setInfoPos(post.getInfoPos());
    		postDto.setInfoTech(post.getInfoTech());
    		postDto.setInfoPosList(post.getInfoPosList());
    		postDto.setInfoTechList(post.getInfoTechList());
    		postDto.setInfoLoc(post.getInfoLoc());
    		postDto.setMaxCareer(post.getMaxCareer());
    		postDto.setMinCareer(post.getMinCareer());
    		postDto.setMaxPay(post.getMaxPay());
    		postDto.setMinPay(post.getMinPay());
    		postDto.setContent(post.getContent());

    		postDtos.add(postDto);
		}
		
		return postDtos;
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