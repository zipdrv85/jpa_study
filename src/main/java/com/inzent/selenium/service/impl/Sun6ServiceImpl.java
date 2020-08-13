package com.inzent.selenium.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.inzent.selenium.com.LoginService;
import com.inzent.selenium.service.Selenium6Service;
import com.inzent.selenium.util.PropertyUtil;

class Sun6ServiceImpl implements Selenium6Service {

	WebDriver driver;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	String userId;
	String userPw;
	String baseUrl;

	JavascriptExecutor js;

	public Sun6ServiceImpl () throws InterruptedException {

		driver = new ChromeDriver();
		userId = PropertyUtil.getConfigValue("selenium.loginId");
		userPw = PropertyUtil.getConfigValue("selenium.loginPw");
		baseUrl = PropertyUtil.getConfigValue("selenium.domain");

		LoginService login = new LoginService();
		boolean log = login.Login6(driver, baseUrl+"/xedrm/app");

		if (!log) return;
		Thread.sleep(1000);

		js = (JavascriptExecutor)driver;

	}

	@Override
	public void case034 ( HttpServletRequest req ) {
	}

	@Override
	public void case035(HttpServletRequest req) {

	}

	@Override
	public void case036(HttpServletRequest req) {

	}

	@Override
	public void case037(HttpServletRequest req) {

	}

	@Override
	public void case038(HttpServletRequest req) {

	}

	@Override
	public void case039(HttpServletRequest req) {

	}

	@Override
	public void case040(HttpServletRequest req) {

	}

	@Override
	public void case041(HttpServletRequest req) {

	}

	@Override
	public void case042(HttpServletRequest req) {

	}

	@Override
	public void case043(HttpServletRequest req) {

	}

	@Override
	public void case044(HttpServletRequest req) {

	}

	@Override
	public void case045(HttpServletRequest req) {

	}

	@Override
	public void case046(HttpServletRequest req) {

	}

	@Override
	public void case047(HttpServletRequest req) {

	}

	@Override
	public void case048(HttpServletRequest req) {

	}

	@Override
	public void case049(HttpServletRequest req) {

	}

	@Override
	public void case050(HttpServletRequest req) {

	}

	@Override
	public void case051(HttpServletRequest req) {

	}

	@Override
	public void case052(HttpServletRequest req) {

	}

	@Override
	public void case053(HttpServletRequest req) {

	}

	@Override
	public void case054(HttpServletRequest req) {

	}

	@Override
	public void case055(HttpServletRequest req) {

	}

	@Override
	public void case056(HttpServletRequest req) {

		try {
			driver.get(baseUrl+"/xedrm/app#/folder/내%20문서함/");
			driver.navigate().refresh();

			if (driver instanceof JavascriptExecutor) {

				Thread.sleep(2000);

				Actions action=new Actions(driver);
				action.keyDown(Keys.CONTROL).build().perform();

				List<WebElement> elements = driver.findElements(By.cssSelector("i[class^='fa fa-file']"));
				for (WebElement element : elements) {
					element.click();
				}

				action.keyUp(Keys.CONTROL).build().perform(); 


				WebElement elementLocator = elements.get(0);
				action.contextClick(elementLocator).perform();

				Thread.sleep(1000);
				js.executeScript("$('.fa.fa-download').click()");

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void case057(HttpServletRequest req) {

	}

	@Override
	public void case058(HttpServletRequest req) {

	}

	@Override
	public void case059(HttpServletRequest req) {

	}

	@Override
	public void case060(HttpServletRequest req) {

	}

	@Override
	public void case061(HttpServletRequest req) {

	}

	@Override
	public void case062(HttpServletRequest req) {


	}

	@Override
	public void case063(HttpServletRequest req) {

	}

	@Override
	public void case064(HttpServletRequest req) {

		try {

			// 파일명 기준
			driver.get(baseUrl+"/xedrm/app#/folder/내%20문서함/");
			driver.navigate().refresh();

			if (driver instanceof JavascriptExecutor) {

				Thread.sleep(2000);

				Actions action=new Actions(driver);

				WebElement fileElement = driver.findElements(By.cssSelector("i[class^='fa fa-file']")).get(0);

				action.contextClick(fileElement).build().perform();

				Thread.sleep(1000);
				js.executeScript("$('.el-icon-edit').click()");

				Thread.sleep(5000);

				boolean present=true;
				while (present) {
					try {
						action.contextClick(fileElement).build().perform();
						present = false;
					} catch (StaleElementReferenceException e) {
						Thread.sleep(1000);
						present=true;
					}
				}


				Thread.sleep(5000);
				js.executeScript("$('.el-icon-edit').click()");
				Thread.sleep(5000);

				WebElement uploadElement = driver.findElement(By.id("checkin-upload"));

				uploadElement.sendKeys(System.getProperty("user.dir")+"/samplefile/newtext.txt");

				if (existElement(driver, "el-dialog__footer")) {
					js.executeScript("$('.el-dialog__footer').find('span').each(function(i,e){ if ($(this).text().indexOf('편집 완료') > -1) { $(this).click(); } });");
				}

				Thread.sleep(2000);

				js.executeScript("$('.el-dialog__footer').find('span').each(function(i,e){ if ($(this).text() == '닫기') { $(this).click(); } });");

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void case065(HttpServletRequest req) {

	}

	@Override
	public void case066(HttpServletRequest req) {

	}

	@Override
	public void case067(HttpServletRequest req) {

	}

	@Override
	public void case068(HttpServletRequest req) {

	}

	@Override
	public void case069(HttpServletRequest req) {

	}

	@Override
	public void case070(HttpServletRequest req) {

	}

	@Override
	public void case071(HttpServletRequest req) {

	}

	@Override
	public void case072(HttpServletRequest req) {

	}

	@Override
	public void case073(HttpServletRequest req) {

	}

	@Override
	public void case074(HttpServletRequest req) {

	}

	@Override
	public void case075(HttpServletRequest req) {

	}

	@Override
	public void case076(HttpServletRequest req)  {

		try {

			driver.get(baseUrl+"/xedrm/app#/folder/내%20문서함/");
			driver.navigate().refresh();

			if (driver instanceof JavascriptExecutor) {

				Thread.sleep(1000);

				js.executeScript("$('.el-icon-plus').click()");
				if (existElement(driver, "newContent-box")) {
					js.executeScript("$('.newContent-box').find('span').each(function(i,e){ if($(this).text().indexOf('폴더') > -1){ $(this).click() } });");
				}
				if (existElement(driver, "el-form-item__content")) {
					js.executeScript("var pkpEl = document.querySelector(\".el-form-item__content input\"); pkpEl.value = '새 폴더_" + dateFormat.format(new Date()) + "'; var event = document.createEvent('Event'); event.initEvent('input', true, true); pkpEl.dispatchEvent(event);");
					js.executeScript("$('.el-dialog__footer').find('span').each(function(i,e){ if($(this).text().indexOf('확인') > -1){ $(this).click() } });");
				}
			}   
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void case077(HttpServletRequest req) {

	}

	@Override
	public void case078(HttpServletRequest req) {

	}

	public boolean existElement(WebDriver driver, String id) throws InterruptedException {
		boolean present=false;
		for(int i=0; i<5; i++) {
			try {
				driver.findElement(By.className(id));
				present = true;
				break;
			} catch (NoSuchElementException e) {
				Thread.sleep(1000);
				continue;
			}
		}
		return present;
	}

}