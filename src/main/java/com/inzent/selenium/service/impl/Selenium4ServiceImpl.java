package com.inzent.selenium.service.impl;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import com.inzent.selenium.com.LoginService;
import com.inzent.selenium.controller.SBAdminUIController;
import com.inzent.selenium.service.Selenium4Service;
import com.inzent.selenium.util.PropertyUtil;


@Slf4j
public class Selenium4ServiceImpl implements Selenium4Service {

	@Autowired
	WebDriver driver; 
	
	private final String base_url = PropertyUtil.getConfigValue("selenium.domain");

	private final String BOOKMARK_CHECKED = "fa fa-star bookmarked";
	private final String BOOKMARK_UNCHECKED = "fa fa-star-o bookmarked";

	public Selenium4ServiceImpl () { }
	
	@Override
	public void case034 ( HttpServletRequest req ) {
		// TODO Auto-generated method stub
		
		System.out.println("case034");

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
		
		// TODO 즐겨찾기 선택
		LoginService.Login4(driver, base_url);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checker;
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		
		log.debug("methodName :: " + methodName);
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
		}
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
