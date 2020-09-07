package com.inzent.selenium.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inzent.selenium.conf.SeleniumWebDriverConfig;
import com.inzent.selenium.entity.Result;
import com.inzent.selenium.entity.ResultAttr;
import com.inzent.selenium.entity.TestCaseAttr;
import com.inzent.selenium.service.ResultService;
import com.inzent.selenium.service.Selenium4Service;
import com.inzent.selenium.service.Selenium6Service;
import com.inzent.selenium.service.TestService;

@Slf4j
@Controller
@RequestMapping("/selenium")
public class SeleniumUrlController {
	
	private String callPackageName = "com.inzent.selenium.service.impl.";

	private final SeleniumWebDriverConfig seleniumWebDriverConfig = new SeleniumWebDriverConfig();
	private final ChromeOptions chromeDriver4Options = seleniumWebDriverConfig.chromeDriver4Options(); 
	private final ChromeOptions chromeDriver6Options = seleniumWebDriverConfig.chromeDriver6Options(); 

	private final ResultService resultService;
	private final TestService testService; 

	public SeleniumUrlController(ResultService resultService, TestService testService) {
		this.resultService = resultService;
		this.testService = testService;
	}
	
	@RequestMapping("/{version}/{className}/{testNumber}/{testId}/start.do")
	private String start(Model model
						, HttpServletRequest request, HttpServletResponse reponse
						//, RedirectAttributes redirectAttributes
						, @PathVariable String version, @PathVariable String className, @PathVariable String testNumber
						, @PathVariable String testId) throws Exception
	{
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

		className = "default".contentEquals(className) ? "Selenium" : className;
		version = "default".contentEquals(version) ? "4.0": "".contentEquals(version) ? "4.0" : version;
		
		if("4.0".contentEquals(version)) {			
			Class<? extends Selenium4Service> service = (Class<? extends Selenium4Service>) Class.forName(callPackageName+className+version.replace(".0", "")+"ServiceImpl");
			Constructor<?> cs = service.getConstructor(this.chromeDriver4Options.getClass());
			Selenium4Service serviceImpl = (Selenium4Service)cs.newInstance(chromeDriver4Options);

			Method method = serviceImpl.getClass().getMethod(testNumber, HttpServletRequest.class);
			method.invoke(serviceImpl, request);

		} else if("6.0".contentEquals(version)) {			
			Class<? extends Selenium6Service> service = (Class<? extends Selenium6Service>) Class.forName(callPackageName+className+version.replace(".0", "")+"ServiceImpl");
			Constructor<?> cs = service.getConstructor(this.chromeDriver6Options.getClass());
			Selenium6Service serviceImpl = (Selenium6Service)cs.newInstance(chromeDriver6Options);

			Method method = serviceImpl.getClass().getMethod(testNumber, HttpServletRequest.class);
			method.invoke(serviceImpl, request);
		}

		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);

		/*테스트 케이스 RESULT 입력*/
		TestCaseAttr testCastAttr = new TestCaseAttr();
		testCastAttr.setTestId(testId);
		testCastAttr.setAttrName("testResult");
		testCastAttr.setAttrValue("true");
		testCastAttr.setDescription("성공여부");
		testService.saveTestCastAttr(testId, testCastAttr);

		
		/*통계 테이블 데이터 입력*/
		Result resultEntity = new Result();
		resultEntity.setExecuteTime(""+secDiffTime);
		resultEntity.setExecuteMehtod("start");
		resultEntity.setExecuteClass("SeleniumUrlController");
		resultEntity.setVersion(version);
		resultEntity.setClassName(className);
		resultEntity.setTestNumber(testNumber);
		resultEntity.setTestId(testId);

		ResultAttr resultAttr = new ResultAttr();
		resultAttr.setAttrName("testResult");
		resultAttr.setAttrValue("true");
		resultAttr.setDescription("성공여부");
		
		resultService.saveResultAndResultAttr(testId, resultEntity, resultAttr);

		return "redirect:/ui/result/selectResult/"+version+"/"+className+"/"+testNumber+"/"+testId;
	}

}