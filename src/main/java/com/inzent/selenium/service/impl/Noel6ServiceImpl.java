package com.inzent.selenium.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.inzent.selenium.service.Selenium6Service;

public class Noel6ServiceImpl extends Selenium6Service {

	public Noel6ServiceImpl () {
		
	}

	@Override
	public void acase076(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
		/*
		String ServerUrl = "http://192.168.21.123:7080/xedrm/app";

		WebDriver driver = new ChromeDriver();
		LoginService.Login6(driver, ServerUrl);

		StringBuffer callScript = new StringBuffer();
		
		String searchingFolder = "부서 문서함/SELENIUM_문서함";


        JavascriptExecutor js;
        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor)driver;

            SeleniumUtil.WaitForLoad(driver, 10);

            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            //부서문서함 열기
            callScript.append("$(\"#folderTreeView\").each(\r\n" + 
            		"					function (index, item) { \r\n" + 
            		"						$(item).children().each(\r\n" + 
            		"							function (index, item){\r\n" + 
            		"								if( $(item).html().indexOf(\""+searchingFolder.split("/")[0]+"\") > -1 )\r\n" + 
            		"								{\r\n" + 
            		"									$(item).children().each( function (index, item)  {\r\n" + 
            		"										if(index == 0) {\r\n" + 
            		"											$(item).find(\".k-icon\").click();\r\n" + 
            		"										}\r\n" + 
            		"									})\r\n" + 
            		"								}\r\n" + 
            		"							}\r\n" + 
            		"						)\r\n" + 
            		"					}\r\n" + 
            		"				)");

            SeleniumUtil.callScript(js, callScript);

            callScript.setLength(0);

            //SELENIUM_문서함 열기
            callScript.append("$(\"#folderTreeView\").each(\r\n" + 
            		"				function (index, item) { \r\n" + 
            		"					$(item).children().each(\r\n" + 
            		"						function (index, item){\r\n" + 
            		"							if( $(item).html().indexOf(\""+searchingFolder.split("/")[0]+"\") > -1 )\r\n" + 
            		"							{\r\n" + 
            		"								$(item).children().each( function (index, item)  {						\r\n" + 
            		"									$(item).find(\".k-item\").each( function (index, item) {\r\n" + 
            		"										if($(item).html().indexOf(\""+searchingFolder.split("/")[1]+"\") > -1) {\r\n" + 
            		"											$(item).find(\".k-top\").find(\".k-in\").click();\r\n" + 
            		"										}\r\n" + 
            		"									})\r\n" + 
            		"								})\r\n" + 
            		"							}\r\n" + 
            		"						}\r\n" + 
            		"					)\r\n" + 
            		"				}\r\n" + 
            		"			)");

            SeleniumUtil.callScript(js, callScript);

            callScript.setLength(0);

            //새로 만들기 클릭
            callScript.append("$(\".el-button.action-btn.el-button--default\").click();");

            SeleniumUtil.callScript(js, callScript);

            callScript.setLength(0);

            //폴더 만들기 클릭
            callScript.append("$($(\".upload-list.toolbar-div-line\")[0]).find(\".material-icons\").click();");

            SeleniumUtil.callScript(js, callScript);

            callScript.setLength(0);

            //값 집어넣기
            callScript.append("$(\".el-dialog__wrapper\").find(\".el-input__inner\").val(\"test\").triggerHandler($.Event(\\\"input\\\"));");

            SeleniumUtil.callScript(js, callScript);

            callScript.setLength(0);

            //폴더 만들기
            callScript.append("$(\".dialog-footer\").find(\".el-button.el-button--primary\").click();");

            SeleniumUtil.callScript(js, callScript);

        }

		*
		 * 	내문서함 열기
			$("#folderTreeView").each(
					function (index, item) { 
						$(item).children().each(
							function (index, item){
								if( $(item).html().indexOf("부서 문서함") > -1 )
								{
									$(item).children().each( function (index, item)  {
										if(index == 0) {
											$(item).find(".k-icon").click();
										}
									})
								}
							}
						)
					}
				)
			
			SELENIUM_문서함 읽기
			$("#folderTreeView").each(
				function (index, item) { 
					$(item).children().each(
						function (index, item){
							if( $(item).html().indexOf("부서 문서함") > -1 )
							{
								$(item).children().each( function (index, item)  {						
									$(item).find(".k-item").each( function (index, item) {
										if($(item).html().indexOf("SELENIUM_문서함") > -1) {
											$(item).find(".k-top").find(".k-in").click();
										}
									})
								})
							}
						}
					)
				}
			)
			
			새로 만들기 클릭
			$(".el-button.action-btn.el-button--default").click();
			
			폴더 만들기 클릭
			$($(".upload-list.toolbar-div-line")[0]).find(".material-icons").click();
			
			값 집어넣기
			$(".el-dialog__wrapper").find(".el-input__inner").val("test");
			
			폴더 만들기
			$(".dialog-footer").find(".el-button.el-button--primary").click();
		*/
	}
	
}
