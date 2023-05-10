package com.example.demo.service;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.Technical_StackRepository;

import jakarta.transaction.Transactional;

import com.example.demo.domain.COMPANY;
import com.example.demo.domain.POST;
import com.example.demo.domain.TECHNICAL_STACK;
import com.example.demo.domain.USER;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class Technical_StackService {
	private final Technical_StackRepository technical_stackrepository;

	public List<TECHNICAL_STACK> findStacks() {
		List<TECHNICAL_STACK> list = technical_stackrepository.findAll();
		return list;
	}


}
