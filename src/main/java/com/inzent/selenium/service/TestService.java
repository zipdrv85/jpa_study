package com.inzent.selenium.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inzent.selenium.dto.TestCaseDTO;
import com.inzent.selenium.dto.TestRequestDTO;
import com.inzent.selenium.dto.TestResponseDTO;
import com.inzent.selenium.entity.Env;
import com.inzent.selenium.entity.EnvAttr;
import com.inzent.selenium.entity.TestCase;
import com.inzent.selenium.entity.TestCaseAttr;
import com.inzent.selenium.repository.TestRepository;

@Slf4j
@Service
public class TestService {

	//NOTE AUTOWIRED DI CHANGE
	private final TestRepository testRepository;

	public TestService (TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Transactional
	public String save(TestRequestDTO testRequestDto) {
		return testRepository.saveAndFlush(testRequestDto.toEntity()).getTestId();
	}
	
	@Transactional
	public TestCase saveTestCastAttr(String testId, TestCaseAttr testCaseAttrParam) {
		
		TestCase testCase = testRepository.findByTestId(testId);
		TestCaseAttr testCaseAttr = testRepository.findByTestCaseAttr(testCaseAttrParam.getTestId(), testCaseAttrParam.getAttrName());
		
		if(testCaseAttr == null) {
			testCase.isNew();
			testCase.addNewTestCaseAttr(testId, testCaseAttrParam);
		} else if(testCaseAttr != null) {
			testCase.getTestCaseAttr().forEach(e -> {
				if(e.getTestId().equals(testCaseAttrParam.getTestId()) && e.getAttrName().equals(testCaseAttrParam.getAttrName())) {
					BeanUtils.copyProperties(testCaseAttrParam, e);
					e.setTestId(testId);
				}
			});
		}
		return testRepository.saveAndFlush(testCase);
	}

	@Transactional(readOnly = true)
	public List<TestResponseDTO> findAllByVersion(String version) {		
		return testRepository
				.findAllByVersion(version)
				.stream()
				.map(TestResponseDTO::new)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<TestCase> findAllByVersion(String version, Pageable pageable) {
		return testRepository
				.findAllByVersion(version, pageable);
	}
	
	@Transactional(readOnly = true)
	public List<TestCaseDTO> findAllByVersionForJpql(String version, String attrName) {
		return testRepository
				.findAllByVersionForJpql(version, attrName);
	}
	
	@Transactional(readOnly = true)
	public List<TestResponseDTO> findAll() {
		return testRepository
				.findAll()
				.stream()
				.map(TestResponseDTO::new)
				.collect(Collectors.toList());
	}
	
	
	@Transactional(readOnly = true)
	public Page<TestCase> findAll(Pageable pageable) {
		return testRepository
				.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public TestCaseDTO findByTestIdAndVersionAndAttrValue(String testId, String version, String attrValue) {
		return testRepository
				.findByTestIdAndVersionAndAttrValue(testId, version, attrValue);
	}
}

