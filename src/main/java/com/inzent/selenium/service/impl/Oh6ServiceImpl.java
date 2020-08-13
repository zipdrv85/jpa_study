package com.inzent.selenium.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.inzent.selenium.com.LoginService;
import com.inzent.selenium.service.Selenium6Service;

public class Oh6ServiceImpl implements Selenium6Service {

   public Oh6ServiceImpl () {
      
   }
   
   @Override
   public void case034 ( HttpServletRequest req ) {
      // TODO Auto-generated method stub

      WebDriver driver = new ChromeDriver();
      LoginService.Login6(driver, "http://192.168.21.123:7080/xedrm/app");
      
      try {
         Thread.sleep(1000);
         JavascriptExecutor js;
         js = (JavascriptExecutor)driver;
         
         driver.get("http://192.168.21.123:7080/xedrm/app#/folder/내%20문서함/새%20폴더");
           driver.navigate().refresh();
           
           Thread.sleep(1000);
           
           List<WebElement> solution = driver.findElements(By.tagName("span"));
           for(WebElement aaa : solution)
           {
              if(aaa.getText().equalsIgnoreCase("새 파일.txt")) {
                 Actions action = new Actions(driver).contextClick(aaa);
                 action.build().perform();
                 }
           }
         
         Thread.sleep(1000);
         js.executeScript("$(document.querySelector(\"#context-menu > div > ul > li:nth-child(8)\")).click();", "");
         //js.executeScript("return $('.ag-center-cols-container')[0].click()");
         
         Thread.sleep(1000);
         WebElement elementRename = driver.findElement(By.id("inputname"));
         elementRename.sendKeys("case034테스트파일");
         
         Thread.sleep(500);
         elementRename.sendKeys(Keys.ENTER);
           
              
      } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   @Override
   public void case035(HttpServletRequest req) {
      // TODO Auto-generated method stub
      
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
      // TODO Auto-generated method stub
      
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
      // TODO Auto-generated method stub
      WebDriver driver = new ChromeDriver();
      LoginService.Login6(driver, "https://drive.inzent.com");
      
      try {
         Thread.sleep(1000);
         JavascriptExecutor js;
         js = (JavascriptExecutor)driver;
         
         driver.get("https://drive.inzent.com/xedrm/app#/folder/내%20문서함/새%20폴더");
           driver.navigate().refresh();
           
           Thread.sleep(1000);
           
           WebElement element = driver.findElement(By.className("ag-center-cols-container"));
            Actions action=new Actions(driver);
           action.keyDown(Keys.CONTROL).build().perform();
           driver.findElement(By.xpath(".//*[@id=\"myGrid\"]/div/div[1]/div/div[3]/div[2]/div/div/div[2]")).click();
           driver.findElement(By.xpath(".//*[@id=\"myGrid\"]/div/div[1]/div/div[3]/div[2]/div/div/div[3]")).click();
           action.keyUp(Keys.CONTROL).build().perform();        
           action.contextClick(element).build().perform();
                    
         Thread.sleep(1000);
           js.executeScript("return $('.context-item')[0].click()");
           
         
              
      } catch (InterruptedException e) {
         // TODO Auto-generated catch block
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
      // TODO Auto-generated method stub
      
      
	   WebDriver driver = new ChromeDriver();
	   LoginService.Login6(driver, "https://drive.inzent.com");

	   try {
		   Thread.sleep(1000);
		   JavascriptExecutor js;
		   js = (JavascriptExecutor)driver;

		   driver.get("https://drive.inzent.com/xedrm/app#/folder/내%20문서함/새%20폴더");
		   driver.navigate().refresh();

		   Thread.sleep(1000);

		   List<WebElement> spanList = driver.findElements(By.tagName("span"));
		   for(WebElement span : spanList)
		   {
			   if(span.getText().equalsIgnoreCase("case064테스트파일.txt")) {
				   Actions action = new Actions(driver).contextClick(span);
				   action.build().perform();
			   }
		   }

		   Thread.sleep(1000);
		   js.executeScript("return $('.context-item')[2].click()");


		   driver.navigate().refresh();

		   Thread.sleep(3000);

		   WebElement editstatus = driver.findElement(By.id("indic_20200522114018mh"));
		   Actions action = new Actions(driver).contextClick(editstatus);
		   action.build().perform();

		   Thread.sleep(1000);
		   js.executeScript("return $('.context-item')[2].click()");

		   Thread.sleep(1000);
		   WebElement uploadBtn = driver.findElement(By.id("checkin-upload"));
		   uploadBtn.sendKeys(System.getProperty("user.dir")+"\\samplefile\\case064테스트파일.txt");


		   Thread.sleep(1000);
		   WebElement editComment = driver.findElement(By.className("el-textarea__inner"));
		   editComment.sendKeys("테스트파일수정");


		   Thread.sleep(1000);
		   List<WebElement> editBtns = driver.findElements(By.tagName("span"));
		   for(WebElement edit : editBtns)
		   {
			   if (edit.getText().indexOf("편집 완료") == -1) continue;

			   if(edit.getText().indexOf("편집 완료") > -1) {
				   edit.click();
				   break;
			   }
		   }

		   Thread.sleep(500);
		   List<WebElement> editClose = driver.findElements(By.tagName("span"));
		   for(WebElement Close : editClose)
		   {
			   if(Close.getText().equalsIgnoreCase("닫기")) {
				   Close.click();
			   }
		   }


	   } catch (InterruptedException e) {
		   // TODO Auto-generated catch block
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
      // TODO Auto-generated method stub
      WebDriver driver = new ChromeDriver();
      LoginService.Login6(driver, "https://drive.inzent.com");
      
      try {
    	  Thread.sleep(1000);
    	  JavascriptExecutor js;
    	  js = (JavascriptExecutor)driver;

    	  driver.get("https://drive.inzent.com/xedrm/app#/folder/내%20문서함/새%20폴더");
    	  driver.navigate().refresh();

    	  Thread.sleep(3000);
    	  WebElement elementFolder = driver.findElement(By.className("el-icon-plus"));
    	  elementFolder.click();

    	  Thread.sleep(1000);
    	  js.executeScript("return $('.new-list')[0].click()");

    	  Thread.sleep(500);
    	  List<WebElement> OKBtn = driver.findElements(By.tagName("span"));
    	  for(WebElement Btn : OKBtn)
    	  {
    		  if(Btn.getText().equalsIgnoreCase("확인")) {
    			  Btn.click();
    		  }
    	  }

      } catch (InterruptedException e) {
    	  // TODO Auto-generated catch block
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