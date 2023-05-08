package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.CompanyRepository;

import jakarta.transaction.Transactional;

import com.example.demo.domain.COMPANY;
import com.example.demo.domain.POST;
import com.example.demo.domain.USER;
import com.example.demo.dto.ValueDto;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ValueService {
	private final UserRepository userRepository;
	private final CompanyRepository companyrepository;
	
	/*
	 * //UserRepository가 final 키워드로 선언되어 있기 때문에 생성자에서 초기화해야 합니다. //이렇게 생성자에서 초기화하면
	 * 해당 필드는 더 이상 null이 아닌 값을 가지게 됩니다. public ValueService(UserRepository
	 * userRepository, CompanyRepository companyrepository) { this.userRepository =
	 * userRepository; this.companyrepository = companyrepository; }
	 */
	
	public USER valueFilter(ValueDto valueDto) {
		
		int usernum = valueDto.getUserNum();
		Double profit = valueDto.getProfit();//1
		Double grow = valueDto.getGrow();//2
		Double stable = valueDto.getStable();//3
		Double pay = valueDto.getPay();//4
		Double scale = valueDto.getScale();//5
		
		System.out.println(scale);
		
		List<double[]> list = new ArrayList<>();
		list.add(new double[]{profit, 1});
		list.add(new double[]{grow, 2});
		list.add(new double[]{stable, 3});
		list.add(new double[]{pay, 4});
		list.add(new double[]{scale, 5});
		
		//들어오는 값 기준으로 
		Collections.sort(list, Comparator.comparingDouble(o -> o[0]));
		
		List<COMPANY> companys = companyrepository.findAll();
		
		List<Object[]>comLists = new ArrayList<>();
		for(COMPANY company: companys) {
			comLists.add(new Object[]{company.getCpName(), company.getProfit(), 
					company.getGrow(), company.getStable(),company.getPay(), company.getScale()});
		}
		
		for (int t = 0; t < 5; t++) {
		    int idx = (int) list.get(t)[1];
		    double value = list.get(t)[0];
		    for (int i = 0; i < comLists.size(); i++) {
		        comLists.get(i)[idx] = Math.abs((double) comLists.get(i)[idx] - value);
		    }
		    Collections.sort(comLists, Comparator.comparingDouble((Object[] o) -> (double) o[idx]).reversed());
		    if(t == 0) comLists.subList(41, comLists.size()).clear();
		    else if(t == 1)comLists.subList(31, comLists.size()).clear();
		    else if(t == 2)comLists.subList(21, comLists.size()).clear();
		    else if(t == 3)comLists.subList(11, comLists.size()).clear();
		    else if(t == 4)comLists.subList(6, comLists.size()).clear();
		}
		
		USER user = userRepository.findByUserNum(usernum);
		user.setPay(pay);
		user.setProfit(profit);
		user.setGrow(grow);
		user.setStable(stable);
		user.setScale(scale);
		user.setCompany1(companyrepository.findByCpName((String)comLists.get(0)[0]));
		user.setCompany2(companyrepository.findByCpName((String)comLists.get(1)[0]));
		user.setCompany3(companyrepository.findByCpName((String)comLists.get(2)[0]));
		user.setCompany4(companyrepository.findByCpName((String)comLists.get(3)[0]));
		user.setCompany5(companyrepository.findByCpName((String)comLists.get(4)[0]));
		userRepository.save(user);
		
		return userRepository.findByUserNum(usernum);
	}
	
	
}
