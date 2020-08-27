package com.inzent.selenium.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inzent.selenium.entity.Env;
import com.inzent.selenium.entity.EnvAttr;
import com.inzent.selenium.service.EnvService;
import com.inzent.selenium.service.TestService;
import com.inzent.selenium.vo.EnvRequestVO;

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
		
		//type List not Count call
		model.addAttribute("testCase", testService.findAllByVersionForJpql(version, "actionUrl"));
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
		
		Env env = envService.findAllByEnvid(envid);

		return env;
	}
	
	@RequestMapping("/env/settings-browser-env")
	private String settingsBrowserEnv(Model model
						, HttpServletRequest request, HttpServletResponse reponse) throws Exception
	{
		log.debug("settingsBrowserEnv");

		model.addAttribute("envCase", envService.findAll());
		return "/env/settings-browser-env";
	}
	
	@RequestMapping("/env/settings-browser-env/{envid}")
	private @ResponseBody Env settingsenvBrowserFindEnv(Model model
						, HttpServletRequest request, HttpServletResponse reponse
						, @PathVariable String envid) throws Exception
	{
		log.debug("tables settingsenvBrowserFindEnv");

		return envService.findAllByEnvid(envid);
	}

	@RequestMapping("/env/settings-browser-env/{envid}/save")
	private @ResponseBody Env settingsenvBrowserSave(Model model
						, Env env) throws Exception
	{
		log.debug("tables settingsenvBrowserSave");

		return envService.saveEnv(env);
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