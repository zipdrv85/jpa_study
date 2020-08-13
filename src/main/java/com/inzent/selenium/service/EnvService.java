package com.inzent.selenium.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inzent.selenium.controller.SBAdminUIController;
import com.inzent.selenium.dto.EnvResponseDto;
import com.inzent.selenium.entity.Env;
import com.inzent.selenium.repository.EnvRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EnvService {

	//NOTE AUTOWIRED DI CHANGE
	private final EnvRepository envRepository;

	public EnvService (EnvRepository envRepository) {
		this.envRepository = envRepository;
	}
	
	@Transactional(readOnly = true)
	public List<EnvResponseDto> findAll() {
		
		log.debug(envRepository.findAll().toString());
		
		return envRepository
				.findAll()
				.stream()
				.map(EnvResponseDto::new)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Env findAllByENVID(String envid) {
		return envRepository
				.findAllByENVID(envid);
	}	
}

