package com.inzent.selenium.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inzent.selenium.dto.ResultDTO;
import com.inzent.selenium.entity.Result;
import com.inzent.selenium.entity.ResultAttr;
import com.inzent.selenium.entity.TestCaseAttr;
import com.inzent.selenium.repository.ResultRepository;

@Slf4j
@Service
public class ResultService {

	//NOTE AUTOWIRED DI CHANGE
	private final ResultRepository resultRepository;

	public ResultService (ResultRepository resultRepository) {
		this.resultRepository = resultRepository;
	}
	
	@Transactional
	public Result saveAndFlush(Result result) {

		return resultRepository.saveAndFlush(result);
	}
	
	@Transactional
	public String save(Result result) {

		return resultRepository.save(result).getResultid();
	}

	@Transactional(readOnly = true)
	public Result findByTestId(String testId) {

		return resultRepository.findByTestId(testId);
	}
	
	@Transactional(readOnly = true)
	public ResultDTO findByTestIdJpql(String testId, String attrName) {

		return resultRepository.findByTestIdJpql(testId, attrName);
	}
	
	@Transactional
	public Result saveResultAndResultAttr(String testId, Result resultParam, ResultAttr resultAttrParam) {
		
		Result resultEntity = resultRepository.findByTestId(testId);
		
		//null 이면 등록
		if(resultEntity == null) {

			resultEntity = new Result();
			resultEntity = resultRepository.save(resultParam);

			resultAttrParam.setResultid(resultEntity.getResultid());

			resultEntity.getResultAttr().add(resultAttrParam);
		} else if(resultEntity != null) { //null 아니면 수정
			ResultDTO resultDTO = resultRepository.findByTestIdJpql(testId, "testResult");
			if( resultDTO == null ) {	//null이면 등록
				resultAttrParam.setResultid(resultEntity.getResultid());
				
				resultEntity.getResultAttr().add(resultAttrParam);
			} else if ( resultDTO != null ) {	//null이면 아니면 수정		
				
				String resultId = resultEntity.getResultid();
				
				resultEntity.getResultAttr().forEach(e -> {
					if(e.getResultid().equals(resultAttrParam.getResultid()) && e.getAttrName().equals(resultAttrParam.getAttrName())) {
						BeanUtils.copyProperties(resultAttrParam, e);
						log.debug("e :::::::::::: "+e.toString());
						e.setResultid(resultId);			
					}
				});
			}
		}
		
		resultRepository.save(resultEntity);
		
		return resultEntity;
	}
}

