package com.inzent.selenium.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inzent.selenium.construct.StaticConstractor;
import com.inzent.selenium.entity.Env;
import com.inzent.selenium.entity.EnvAttr;
import com.inzent.selenium.repository.EnvAttrRepository;
import com.inzent.selenium.repository.EnvRepository;

@Slf4j
@Service
public class EnvAttrService {

	//NOTE AUTOWIRED DI CHANGE
	private final EnvAttrRepository envAttrRepository;

	public EnvAttrService (EnvAttrRepository envAttrRepository) {
		this.envAttrRepository = envAttrRepository;
	}
	
	@Transactional(readOnly = true)
	public List<EnvAttr> findAll() {		
		return envAttrRepository
				.findAll();
	}
}

