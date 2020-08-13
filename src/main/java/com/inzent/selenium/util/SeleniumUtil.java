package com.inzent.selenium.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {

	public static void WaitForLoad(WebDriver driver, int timeoutSec)
	{
		new WebDriverWait(driver, timeoutSec).until((ExpectedCondition<Boolean>) wd -> 
		((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	}
	
	public static boolean onloadCheck(WebDriver driver, String jQuerySelector) {
		int cnt = 3;
		WebElement checker;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		do {
			/*렌더링 종료 확인*/
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			checker = (WebElement)js.executeScript("return "+jQuerySelector, "");
			if(cnt == 0)
				return false;
			cnt --;
		}while(null == checker);
		
		return true;
	}
}
