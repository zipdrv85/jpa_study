package com.inzent.selenium.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.inzent.selenium.com.LoginService;
import com.inzent.selenium.service.Selenium6Service;

public class Noel6ServiceImpl implements Selenium6Service {

	public Noel6ServiceImpl () {
		
	}
	
	@Override
	public void case034 ( HttpServletRequest req ) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		LoginService.Login6(driver, "");

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

	@Override
	public void case077(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void case078(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}
	
}
