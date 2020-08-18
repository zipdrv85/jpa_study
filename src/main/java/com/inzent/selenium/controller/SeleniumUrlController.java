package com.inzent.selenium.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inzent.selenium.service.Selenium4Service;
import com.inzent.selenium.service.Selenium6Service;
import com.inzent.selenium.util.PropertyUtil;
import com.inzent.selenium.vo.User;

@Controller
@RequestMapping("/selenium")
public class SeleniumUrlController {
	
	private String callPackageName = "com.inzent.selenium.service.impl.";

	private final ChromeOptions chromeDriverOptions; 
	
	/*
	@PostConstruct
	private void setSeleniumSystemDriver () {
        //Selenium WebDrvier Settings		
        //System.setProperty(PropertyUtil.getConfigValue("selenium.webDriverName"), System.getProperty("user.dir")+PropertyUtil.getConfigValue("selenium.webDriverPath8.0"));
	}*/
	
	public SeleniumUrlController(ChromeOptions chromeDriverOptions) {
		this.chromeDriverOptions = chromeDriverOptions;
	}
	
	@RequestMapping("/{version}/{className}/{testNumber}/start.do")
	private String start(Model model
						, HttpServletRequest request, HttpServletResponse reponse
						, @PathVariable String version, @PathVariable String className, @PathVariable String testNumber) throws Exception
	{

		className = "default".contentEquals(className) ? "Selenium" : className;
		version = "default".contentEquals(version) ? "4": "".contentEquals(version) ? "4" : version;

		if("4".contentEquals(version)) {			
			Class<? extends Selenium4Service> service = (Class<? extends Selenium4Service>) Class.forName(callPackageName+className+version+"ServiceImpl");
			Constructor<?> cs = service.getConstructor(this.chromeDriverOptions.getClass());
			Selenium4Service serviceImpl = (Selenium4Service)cs.newInstance(chromeDriverOptions);

			Method method = serviceImpl.getClass().getMethod(testNumber, HttpServletRequest.class);
			method.invoke(serviceImpl, request);

		} else if("6".contentEquals(version)) {			
			Class<? extends Selenium6Service> service = (Class<? extends Selenium6Service>) Class.forName(callPackageName+className+version+"ServiceImpl");
			Constructor<?> cs = service.getConstructor(this.chromeDriverOptions.getClass());
			Selenium6Service serviceImpl = (Selenium6Service)cs.newInstance(chromeDriverOptions);

			Method method = serviceImpl.getClass().getMethod(testNumber, HttpServletRequest.class);
			method.invoke(serviceImpl, request);
		}

        User user = new User("kkaok", "테스트", "web") ;
        model.addAttribute("user", user);

		return "test";
	}

}