package com.inzent.selenium.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inzent.selenium.dto.TestRequestDto;
import com.inzent.selenium.dto.TestResponseDto;
import com.inzent.selenium.entity.TestCase;
import com.inzent.selenium.repository.TestRepository;

@Service
public class TestService {

	//NOTE AUTOWIRED DI CHANGE
	private final TestRepository testRepository;

	public TestService (TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Transactional
	public String save(TestRequestDto testRequestDto) {
		return testRepository.save(testRequestDto.toEntity()).getTEST_ID();
	}

	@Transactional(readOnly = true)
	public List<TestResponseDto> findAllByVERSION(String version) {
		return testRepository
				.findAllByVERSION(version)
				.stream()
				.map(TestResponseDto::new)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<TestResponseDto> findAll() {
		return testRepository
				.findAll()
				.stream()
				.map(TestResponseDto::new)
				.collect(Collectors.toList());
	}

}

