package com.example.demo.service;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.PositionRepository;
import com.example.demo.repository.Technical_StackRepository;

import jakarta.transaction.Transactional;

import com.example.demo.domain.COMPANY;
import com.example.demo.domain.POSITIONS;
import com.example.demo.domain.POST;
import com.example.demo.domain.TECHNICAL_STACK;
import com.example.demo.domain.USER;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class Technical_StackService {
	private final Technical_StackRepository technical_stackrepository;
	private final PositionRepository positionrepository;
	
	public List<TECHNICAL_STACK> findStacks() {
		//year가 0인 친구만 나오게 함-> techname 같은거 많아서 year로 구분함
		List<TECHNICAL_STACK> list = technical_stackrepository.findByYear(0);
		return list;
	}

	public Map<String, Object> findTopSixLan(int year, int month) {
		//상위 6개 노출
		List<TECHNICAL_STACK> lan_list = technical_stackrepository.findTopSix(year, month);
		int etc = technical_stackrepository.findEtc(year, month);
		int total = technical_stackrepository.findTotalMonth(year, month);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("total", total);
		result.put("etc", etc);
		result.put("lan_list", lan_list);
		result.put("language", lan_list.get(0).getTechName());
		
		return result;
	}

	public Map<String, Object> findThreePos(int year, int month, List<String> jobList) {
		// 직무 3개 찾아서 값들 다 보내줌
		List<POSITIONS> job1 =positionrepository.findPosInfo(jobList.get(0), year, month);
		List<POSITIONS> job2 =positionrepository.findPosInfo(jobList.get(1), year, month);
		List<POSITIONS> job3 =positionrepository.findPosInfo(jobList.get(2), year, month);
		
		//해당 달의 가장 많이 뽑은 직군
		POSITIONS top_jop = positionrepository.findTopJob(jobList.get(0), jobList.get(1), jobList.get(2), year, month);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("job", top_jop.getPosName());
		result.put("job1", job1);
		result.put("job2", job2);
		result.put("job3", job3);
		
		return result;
	}

	public Map<String, Object> findThreeStacks(int year, int month, String job) {
		List<TECHNICAL_STACK> stacks =technical_stackrepository.findStacks(job, year, month);
		String stack = stacks.get(0).getTechName();
		Map<String, Object> result = new HashMap<>();
		
		result.put("stacks", stacks );
		result.put("stack", stack );
		return result;
	}

}
