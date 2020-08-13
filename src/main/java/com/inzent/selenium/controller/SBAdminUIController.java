package com.inzent.selenium.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inzent.selenium.entity.Env;
import com.inzent.selenium.service.EnvService;
import com.inzent.selenium.service.TestService;

import lombok.extern.slf4j.Slf4j;

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
	private String tables(Model model
						, HttpServletRequest request, HttpServletResponse reponse
						, @PathVariable String version) throws Exception
	{
		log.debug("tables start");

		model.addAttribute("testCase", testService.findAllByVERSION(version));
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

		return envService.findAllByENVID(envid);
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