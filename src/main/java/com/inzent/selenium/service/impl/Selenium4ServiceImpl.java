package com.inzent.selenium.service.impl;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;

import com.inzent.selenium.com.LoginService;
import com.inzent.selenium.construct.StaticConstractor;
import com.inzent.selenium.controller.SBAdminUIController;
import com.inzent.selenium.service.Selenium4Service;
import com.inzent.selenium.util.PropertyUtil;
import com.inzent.selenium.util.StringUtil;


@Slf4j
public class Selenium4ServiceImpl extends Selenium4Service {

	private final ChromeOptions chromeDriverOptions;
	private final String base_url = StringUtil.NVL(StaticConstractor.url4, PropertyUtil.getConfigValue("selenium.domain"));
	private final String BOOKMARK_CHECKED = "fa fa-star bookmarked";

	public Selenium4ServiceImpl (ChromeOptions chromeDriverOptions) {
		this.chromeDriverOptions = chromeDriverOptions;
	}

	@Override
	public void case001 ( HttpServletRequest req ){
		ChromeDriver driver = new ChromeDriver(chromeDriverOptions);
		
		try {
			
			LoginService.Login4(driver, base_url);
			
		} catch (Exception e) {
			
		} finally {
			driver.quit();
		}
		
	}
	
	@Override
	public void case037(HttpServletRequest req) {

		ChromeDriver driver = new ChromeDriver(chromeDriverOptions);

		// TODO 즐겨찾기 선택
		LoginService.Login4(driver, base_url);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checker;

		try {
			do {
				/*렌더링 종료 확인*/
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				checker = (WebElement) js.executeScript("return $(\"div #tablev_toolbar\").get(0)",
						"");

			} while (checker.equals(null));

			//			즐겨찾기 대상 탐색
			String bookmardChecked = (String) js.executeScript(
					"return $(\"div .ag-body-viewport span:contains('POC') > .ag-cell-value > span > [title='즐겨찾기']\").attr('class')",
					"");
			if (bookmardChecked.equalsIgnoreCase(BOOKMARK_CHECKED)) {
				throw new Exception("대상건이 없습니다.");
			}

			WebElement target = (WebElement) js.executeScript(
					"return $(\"div .ag-body-viewport span:contains('POC') > .ag-cell-value > span > [title='즐겨찾기']\").get(0)",
					"");
			target.click();

			/*즐겨찾기 등록 결과 확인*/
			WebElement bookmarkElement = (WebElement) js.executeScript(
					"return $(\"div #edrm-left li span.k-in:contains('즐겨찾기')\").get(0)", "");
			bookmarkElement.click();

			do {
				/*렌더링 종료 확인*/
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				checker = (WebElement) js.executeScript("return $(\"div #tablev_toolbar\").get(0)",
						"");
			} while (checker.equals(null));

			target = null;
			target = (WebElement) js.executeScript(
					"return $(\"div #main-tableview div.ag-row:contains('POC')\").get(0)", "");

			if (target == null)
				throw new Exception("case[" + new Object() {
				}.getClass().getEnclosingMethod().getName() + "] 즐겨찾기 실패");

		} catch (Exception e) {
			js.executeScript("alert('" + e.getMessage() + "')", "");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} finally {
			driver.quit();
		}
	}
	
}
