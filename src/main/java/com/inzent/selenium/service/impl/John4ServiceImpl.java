package com.inzent.selenium.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.inzent.selenium.com.LoginService;
import com.inzent.selenium.service.Selenium4Service;
import com.inzent.selenium.util.PropertyUtil;

public class John4ServiceImpl extends Selenium4Service {

	public John4ServiceImpl () {

	}

	@Override
	public void case034 ( HttpServletRequest req ) {
		String startUrl = PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/";

		WebDriver driver = new ChromeDriver();
		LoginService.Login4(driver, startUrl);

		try {
			Thread.sleep(1000);

			JavascriptExecutor jse = (JavascriptExecutor)driver;

			// 부서문서함 내 test 폴더 접근
			driver.get(PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/#/files/%EB%B6%80%EC%84%9C%20%EB%AC%B8%EC%84%9C%ED%95%A8/test/");
			driver.navigate().refresh();
			Thread.sleep(1000);

			// 파일 클릭
			jse.executeScript(""
					+ "$(\".ag-body-container.ag-layout-normal\").children().each("
					+ "	function (i,item) { "
					+ "		if($(item).html().indexOf('이름바꾸기테스트.txt') > -1){"
					+ "			$(item).children().each("
					+ "				function (j,jtem) { "
					+ "					if($(jtem).html().indexOf('ag-selection-checkbox') > -1){"
					+ "						$(jtem).find('.ag-icon.ag-icon-checkbox-unchecked').click();"
					+ "					}"
					+ "				}"
					+ "			)"
					+ "		}"
					+ "	}"
					+ ")"
					);
			Thread.sleep(1000);

			// 액션메뉴 클릭
			jse.executeScript(""
					+ "$(\"#actionMenu\").click();"
					);
			Thread.sleep(1000);

			// 이름바꾸기 클릭
			jse.executeScript(""
					+ "$(\".fa.fa-pencil-square-o\").click();"
					);
			Thread.sleep(3000);

			// 변경할 이름 작성
			jse.executeScript(""
					+ "var nameInput = document.querySelector('#inputname');"
					+ "nameInput.value = '이름바꾸기테스트완료.txt';"
					+ "var event = document.createEvent('Event');"
					+ "event.initEvent('input', true, true);"
					+ "nameInput.dispatchEvent(event);"
					);
			Thread.sleep(1000);

			// 확인 버튼 클릭
			jse.executeScript(""
					+ "$(\"span:contains('확인')\").click();"
					);
			Thread.sleep(3000);

			// 파일 클릭
			jse.executeScript(""
					+ "$(\".ag-body-container.ag-layout-normal\").children().each("
					+ "	function (i,item) { "
					+ "		if($(item).html().indexOf('이름바꾸기테스트완료.txt') > -1){"
					+ "			$(item).children().each("
					+ "				function (j,jtem) { "
					+ "					if($(jtem).html().indexOf('ag-selection-checkbox') > -1){"
					+ "						$(jtem).find('.ag-icon.ag-icon-checkbox-unchecked').click();"
					+ "					}"
					+ "				}"
					+ "			)"
					+ "		}"
					+ "	}"
					+ ")"
					);
			Thread.sleep(1000);

			// 액션메뉴 클릭
			jse.executeScript(""
					+ "$(\"#actionMenu\").click();"
					);
			Thread.sleep(1000);

			// 이름바꾸기 클릭
			jse.executeScript(""
					+ "$(\".fa.fa-pencil-square-o\").click();"
					);
			Thread.sleep(3000);

			// 변경할 이름 작성
			jse.executeScript(""
					+ "var nameInput = document.querySelector('#inputname');"
					+ "nameInput.value = '이름바꾸기테스트.txt';"
					+ "var event = document.createEvent('Event');"
					+ "event.initEvent('input', true, true);"
					+ "nameInput.dispatchEvent(event);"
					);
			Thread.sleep(1000);

			// 확인 버튼 클릭
			jse.executeScript(""
					+ "$(\"span:contains('확인')\").click();"
					);
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void case035(HttpServletRequest req) {
		String startUrl = PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/";

		WebDriver driver = new ChromeDriver();
		LoginService.Login4(driver, startUrl);

		try {
			Thread.sleep(1000);

			JavascriptExecutor jse = (JavascriptExecutor)driver;

			// 부서문서함 내 test 폴더 접근
			driver.get(PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/#/files/%EB%B6%80%EC%84%9C%20%EB%AC%B8%EC%84%9C%ED%95%A8/test/");
			driver.navigate().refresh();
			Thread.sleep(1000);

			// 파일 클릭
			jse.executeScript(""
					+ "$(\".ag-body-container.ag-layout-normal\").children().each("
					+ "	function (i,item) { "
					+ "		if($(item).html().indexOf('설명수정테스트.txt') > -1){"
					+ "			$(item).children().each("
					+ "				function (j,jtem) { "
					+ "					if($(jtem).html().indexOf('ag-selection-checkbox') > -1){"
					+ "						$(jtem).find('.ag-icon.ag-icon-checkbox-unchecked').click();"
					+ "					}"
					+ "				}"
					+ "			)"
					+ "		}"
					+ "	}"
					+ ")"
					);
			Thread.sleep(1000);

			// 액션메뉴 클릭
			jse.executeScript(""
					+ "$(\"#actionMenu\").click();"
					);
			Thread.sleep(1000);

			// 속성 클릭
			jse.executeScript(""
					+ "$(\"li:contains('속성')\").click()"
					);
			Thread.sleep(1000);

			// 설명 작성
			jse.executeScript(""
					+ "$(\".el-textarea__inner\").val(\"설명작성완료\");"
					+ "$(\".el-textarea__inner\").focus();"
					+ "var event = document.createEvent('Event');"
					+ "event.initEvent('input', true, true);"
					+ "document.querySelector(\".el-textarea__inner\").dispatchEvent(event);"
					);
			Thread.sleep(1000);
			
//			jse.executeScript(""
//					+ "var explainInput = document.querySelector('.el-textarea__inner');"
//					+ "explainInput.value = '설명작성완료';"
//					+ "var event = document.createEvent('Event');"
//					+ "event.initEvent('input', true, true);"
//					+ "explainInput.dispatchEvent(event);"
//					);
//			Thread.sleep(1000);
			
//			WebElement explainElement = driver.findElement(By.className("el-textarea__inner"));
//			explainElement.click();
//			explainElement.clear();
//			explainElement.sendKeys("설명작성완료");
//			Thread.sleep(1000);
			
//			WebElement closeElement = driver.findElement(By.id("propertyDialog"));
//			closeElement.sendKeys(Keys.ESCAPE);
//			Thread.sleep(1000);
			
			
			
			// 닫기 클릭
//			jse.executeScript(""
//					+ "$(\"span:contains('닫기')\").click();"
//					);
//			Thread.sleep(1000);

			
			Actions actionEnter = new Actions(driver);
			actionEnter.sendKeys(Keys.ENTER).perform();
			Thread.sleep(1000);
			
			Actions actionEsc = new Actions(driver);
			actionEsc.sendKeys(Keys.ESCAPE).perform();
			Thread.sleep(1000);

			// 닫기 클릭
//			jse.executeScript(""
//					+ "$(\"#propertyDialog\").click();"
//					);
//			Thread.sleep(1000);
			
//			// 파일 클릭
//			jse.executeScript(""
//					+ "$(\".ag-body-container.ag-layout-normal\").children().each("
//					+ "	function (i,item) { "
//					+ "		if($(item).html().indexOf('설명수정테스트.txt') > -1){"
//					+ "			$(item).children().each("
//					+ "				function (j,jtem) { "
//					+ "					if($(jtem).html().indexOf('ag-selection-checkbox') > -1){"
//					+ "						$(jtem).find('.ag-icon.ag-icon-checkbox-unchecked').click();"
//					+ "					}"
//					+ "				}"
//					+ "			)"
//					+ "		}"
//					+ "	}"
//					+ ")"
//					);
//			Thread.sleep(1000);

			// 액션메뉴 클릭
			jse.executeScript(""
					+ "$(\"#actionMenu\").click();"
					);
			Thread.sleep(1000);

			// 속성 클릭
			jse.executeScript(""
					+ "$(\"li:contains('속성')\").click();"
					);
			Thread.sleep(3000);

			// 닫기 클릭
			jse.executeScript(""
					+ "$(\"span:contains('닫기')\").click();"
					);
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void case036(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case037(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case038(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case039(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case040(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case041(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case042(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case043(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case044(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case045(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case046(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case047(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case048(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case049(HttpServletRequest req) {
		String startUrl = PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/";

		WebDriver driver = new ChromeDriver();
		LoginService.Login4(driver, startUrl);

		try {
			Thread.sleep(1000);

			JavascriptExecutor jse = (JavascriptExecutor)driver;

			// 부서문서함 내 test 폴더 접근
			driver.get(PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/#/files/%EB%B6%80%EC%84%9C%20%EB%AC%B8%EC%84%9C%ED%95%A8/test/");
			driver.navigate().refresh();
			Thread.sleep(1000);

			/////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////// 파일 업로드 ////////////////////////////////////////
			jse.executeScript("$(\".fa.fa-upload\").click();", "");
			Thread.sleep(1000);
			WebElement uploadElement = driver.findElement(By.id("files"));
			String source = System.getProperty("user.dir")+"/samplefile/newtext.txt";
			String dest = System.getProperty("user.dir")+"/samplefile/삭제테스트.txt";
			Files.copy(new File(source).toPath(), new File(dest).toPath(), StandardCopyOption.REPLACE_EXISTING);
			uploadElement.sendKeys(dest);
			Thread.sleep(1000);
			driver.findElement(By.id("uploadBtn")).click();
			Thread.sleep(1000);
			jse.executeScript("$(\"#uploadBtn\").parent().find(\".el-button.el-button--default\").click();", "");
			Thread.sleep(1000);
			/////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////

			// 파일 클릭
			jse.executeScript(""
					+ "$(\".ag-body-container.ag-layout-normal\").children().each("
					+ "	function (i,item) { "
					+ "		if($(item).html().indexOf('삭제테스트.txt') > -1){"
					+ "			$(item).children().each("
					+ "				function (j,jtem) { "
					+ "					if($(jtem).html().indexOf('ag-selection-checkbox') > -1){"
					+ "						$(jtem).find('.ag-icon.ag-icon-checkbox-unchecked').click();"
					+ "					}"
					+ "				}"
					+ "			)"
					+ "		}"
					+ "	}"
					+ ")"
					);
			Thread.sleep(1000);

			// 액션메뉴 클릭
			jse.executeScript(""
					+ "$(\"#actionMenu\").click();"
					);
			Thread.sleep(1000);

			// 삭제 클릭
			jse.executeScript(""
					+ "$(\".fa.fa-trash-o\").click();"
					);
			Thread.sleep(1000);

			// 확인 클릭
			jse.executeScript(""
					+ "$(\".el-button.el-button--danger\").click();"
					);
			Thread.sleep(5000);

		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void case050(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case051(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case052(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case053(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case054(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case055(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case056(HttpServletRequest req) {
		String startUrl = PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/";

		WebDriver driver = new ChromeDriver();
		LoginService.Login4(driver, startUrl);

		try {
			Thread.sleep(1000);

			JavascriptExecutor jse = (JavascriptExecutor)driver;

			// 부서문서함 내 test 폴더 접근
			driver.get(PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/#/files/%EB%B6%80%EC%84%9C%20%EB%AC%B8%EC%84%9C%ED%95%A8/test/");
			driver.navigate().refresh();
			Thread.sleep(1000);

			// 파일1 클릭
			jse.executeScript(""
					+ "$(\".ag-body-container.ag-layout-normal\").children().each("
					+ "	function (i,item) { "
					+ "		if($(item).html().indexOf('다운로드복수테스트1.txt') > -1){"
					+ "			$(item).children().each("
					+ "				function (j,jtem) { "
					+ "					if($(jtem).html().indexOf('ag-selection-checkbox') > -1){"
					+ "						$(jtem).find('.ag-icon.ag-icon-checkbox-unchecked').click();"
					+ "					}"
					+ "				}"
					+ "			)"
					+ "		}"
					+ "	}"
					+ ")"
					);
			Thread.sleep(1000);

			// 파일2 클릭
			jse.executeScript(""
					+ "$(\".ag-body-container.ag-layout-normal\").children().each("
					+ "	function (i,item) { "
					+ "		if($(item).html().indexOf('다운로드복수테스트2.txt') > -1){"
					+ "			$(item).children().each("
					+ "				function (j,jtem) { "
					+ "					if($(jtem).html().indexOf('ag-selection-checkbox') > -1){"
					+ "						$(jtem).find('.ag-icon.ag-icon-checkbox-unchecked').click();"
					+ "					}"
					+ "				}"
					+ "			)"
					+ "		}"
					+ "	}"
					+ ")"
					);
			Thread.sleep(1000);

			// 액션메뉴 클릭
			jse.executeScript(""
					+ "$(\"#actionMenu\").click();"
					);
			Thread.sleep(1000);

			// 다운로드 클릭
			jse.executeScript(""
					+ "$(\".fa.fa-download\").click();"
					);
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void case057(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case058(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case059(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case060(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case061(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case062(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case063(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case064(HttpServletRequest req) {
		String startUrl = PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/";

		WebDriver driver = new ChromeDriver();
		LoginService.Login4(driver, startUrl);

		try {
			Thread.sleep(1000);

			JavascriptExecutor jse = (JavascriptExecutor)driver;

			// 부서문서함 내 test 폴더 접근
			driver.get(PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/#/files/%EB%B6%80%EC%84%9C%20%EB%AC%B8%EC%84%9C%ED%95%A8/test/");
			driver.navigate().refresh();
			Thread.sleep(1000);

			// 파일 클릭
			jse.executeScript(""
					+ "$(\".ag-body-container.ag-layout-normal\").children().each("
					+ "	function (i,item) { "
					+ "		if($(item).html().indexOf('버전관리테스트.txt') > -1){"
					+ "			$(item).children().each("
					+ "				function (j,jtem) { "
					+ "					if($(jtem).html().indexOf('ag-selection-checkbox') > -1){"
					+ "						$(jtem).find('.ag-icon.ag-icon-checkbox-unchecked').click();"
					+ "					}"
					+ "				}"
					+ "			)"
					+ "		}"
					+ "	}"
					+ ")"
					);
			Thread.sleep(1000);

			// 액션메뉴 클릭
			jse.executeScript(""
					+ "$(\"#actionMenu\").click();"
					);
			Thread.sleep(1000);

			// 편집모드 클릭
			jse.executeScript(""
					+ "$(\".edm.icon_new_edit\").click();"
					);
			Thread.sleep(3000);

			// 파일 클릭
			jse.executeScript(""
					+ "$(\".ag-body-container.ag-layout-normal\").children().each("
					+ "	function (i,item) { "
					+ "		if($(item).html().indexOf('버전관리테스트.txt') > -1){"
					+ "			$(item).click();"
					+ "		}"
					+ "	}"
					+ ") "
					);
			Thread.sleep(1000);

			// 액션메뉴 클릭
			jse.executeScript(""
					+ "$(\"#actionMenu\").click();"
					);
			Thread.sleep(1000);

			// 편집완료 클릭
			jse.executeScript(""
					+ "$(\".edm.icon_new_editcompletion\").click();"
					);
			Thread.sleep(1000);

			// 코멘트 작성
			jse.executeScript(""
					+ "var commnetInput = document.querySelector('.el-textarea__inner');"
					+ "commnetInput.value = '버전관리테스트';"
					+ "var event = document.createEvent('Event');"
					+ "event.initEvent('input', true, true);"
					+ "commnetInput.dispatchEvent(event);"
					);
			Thread.sleep(1000);

			// 파일선택 클릭
			WebElement uploadElement = driver.findElement(By.id("files"));			
			String source = System.getProperty("user.dir")+"/samplefile/newtext.txt";
			String dest = System.getProperty("user.dir")+"/samplefile/버전관리테스트.txt";
			Files.copy(new File(source).toPath(), new File(dest).toPath(), StandardCopyOption.REPLACE_EXISTING);
			uploadElement.sendKeys(dest);
			Thread.sleep(1000);

			// 확인 버튼 클릭
			jse.executeScript(""
					+ "$(\"span:contains('확인')\").click();"
					);
			Thread.sleep(5000);

		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void case065(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case066(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case067(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case068(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case069(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case070(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case071(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case072(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case073(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case074(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case075(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case076(HttpServletRequest req) {
		String startUrl = PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/";

		WebDriver driver = new ChromeDriver();
		LoginService.Login4(driver, startUrl);

		try {
			Thread.sleep(1000);

			JavascriptExecutor jse = (JavascriptExecutor)driver;

			// 부서문서함 내 test 폴더 접근
			driver.get(PropertyUtil.getConfigValue("selenium.domain") + "/xedrm/app/#/files/%EB%B6%80%EC%84%9C%20%EB%AC%B8%EC%84%9C%ED%95%A8/test/");
			driver.navigate().refresh();
			Thread.sleep(1000);

			StringBuilder str = new StringBuilder();
			String str1 = "" + "";
			
			str.append("");
			
			// 등록 버튼 클릭
			jse.executeScript(""
					+ "$(\"span:contains('등록')\").click();"
					);
			Thread.sleep(1000);
			
			str.setLength(0);

			// 신규 폴더 클릭
			jse.executeScript(""
					+ "$(\".edm.icon_new_newfolder\").click();"
					);
			Thread.sleep(1000);

			// 폴더 명 작성
			jse.executeScript(""
					+ "var folderInput = document.querySelector('input[type=text][autofocus=autofocus]');"
					+ "folderInput.value = '폴더생성테스트';"
					+ "var event = document.createEvent('Event');"
					+ "event.initEvent('input', true, true);"
					+ "folderInput.dispatchEvent(event);"
					);
			Thread.sleep(1000);

			// 확인 버튼 클릭
			jse.executeScript(""
					+ "$(\"span:contains('확인')\").click();"
					);
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void case077(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void case078(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

}
