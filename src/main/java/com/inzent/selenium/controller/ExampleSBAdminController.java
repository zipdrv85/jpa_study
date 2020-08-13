package com.inzent.selenium.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ui/example")
public class ExampleSBAdminController {
	
	@RequestMapping("/{selector}")
	private String templateSelector(Model model
						, HttpServletRequest request, HttpServletResponse reponse
						, @PathVariable String selector) throws Exception
	{
		return "example/"+selector;
	}
}