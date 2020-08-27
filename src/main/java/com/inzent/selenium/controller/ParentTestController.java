package com.inzent.selenium.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inzent.selenium.service.EnvService;
import com.inzent.selenium.service.ParentTestService;
import com.inzent.selenium.service.TestService;

@Slf4j
@Controller
@RequestMapping("/parent")
public class ParentTestController {
	
	private final ParentTestService parentTestService;
	
	public ParentTestController (ParentTestService parentTestService) {
		this.parentTestService = parentTestService;
	}

	//테스트케이스 목록 6 버전 4버전
	@RequestMapping("/parentSave")
	private String parentSave(Model model
						, HttpServletRequest request, HttpServletResponse reponse) throws Exception
	{
		log.debug("parentSave");
		
		parentTestService.save();
		
		return "tables";
	}
}