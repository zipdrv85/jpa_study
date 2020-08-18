package com.inzent.selenium.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inzent.selenium.entity.Env;
import com.inzent.selenium.entity.TestCase;
import com.inzent.selenium.service.EnvService;
import com.inzent.selenium.service.TestService;

@Slf4j
@Controller
@RequestMapping("/ui")
public class SBAdminUIController {
	
	private final TestService testService;
	private final EnvService envService;
	
	public SBAdminUIController (TestService testService, EnvService envService) {
		this.testService = testService;
		this.envService = envService;
	}

	//테스트케이스 목록 6 버전 4버전
	@RequestMapping("/tables/{version}")
	private String tables(Pageable pageable
						, Model model
						, HttpServletRequest request, HttpServletResponse reponse
						, @PathVariable String version) throws Exception
	{
		log.debug("tables start");
		
		PageRequest page1 = PageRequest.of(0, 10, Sort.by("testId").and(Sort.by("procedure")));
		//Sort.by("TEST_ID").ascending()

		//type Page Count call
		Page<TestCase> page = testService.findAll(page1);
		log.debug("page.getTotalElements() :: "+page.getTotalElements());

		//type List not Count call
		model.addAttribute("testCase", testService.findAllByVersion(version));
		return "tables";
	}
	
	@RequestMapping("/env/settings-env")
	private String settingsenv(Model model
						, HttpServletRequest request, HttpServletResponse reponse) throws Exception
	{
		log.debug("tables settingsenv");

		model.addAttribute("envCase", envService.findAll());
		return "/env/settings-env";
	}
	
	@RequestMapping("/env/settings-env/{envid}")
	private @ResponseBody Env settingsenvFindEnv(Model model
						, HttpServletRequest request, HttpServletResponse reponse
						, @PathVariable String envid) throws Exception
	{
		log.debug("tables settingsenvFindEnv");

		//log.debug(""+envService.findAllByURL("http://192.168.21.98:7080/xedrm/app"));
		
		return envService.findAllByEnvid(envid);
	}

	//default selector
	@RequestMapping("/{selector}")
	private String selector(Model model
						, HttpServletRequest request, HttpServletResponse reponse
						, @PathVariable String selector) throws Exception
	{
		log.debug("tables start");

		model.addAttribute("testCase", testService.findAll());
		return selector;
	}
}