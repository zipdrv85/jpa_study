package com.inzent.selenium.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.inzent.selenium.service.Selenium4Service;
import com.inzent.selenium.util.ETCUtil;
import com.inzent.selenium.util.SeleniumUtil;
import com.inzent.selenium.util.StringUtil;

public class Jhc4ServiceImpl extends Selenium4Service {

	private WebDriver driver;

	public static final String WEB_DRIVE_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "./driver/chrome8.3/chromedriver.exe";

	public static final String BOOKMARK_CHECKED = "fa fa-star bookmarked";
	public static final String BOOKMARK_UNCHECKED = "fa fa-star-o bookmarked";

	private String base_url;

	public Jhc4ServiceImpl() {
		super();
		System.setProperty(WEB_DRIVE_ID, WEB_DRIVER_PATH);

		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options);
		base_url = "http://localhost:7080/xedrm/app/#/login";

	}

	@Override
	public void case034(HttpServletRequest req) {

		System.out.println("jhc case034");

	}

	@Override
	public void case035(HttpServletRequest req) {

	}

	@Override
	public void case036(HttpServletRequest req) {

	}

	@Override
	public void case037(HttpServletRequest req) {
		// TODO 즐겨찾기 선택
		//LoginService.Login4(driver, base_url);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checker;
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
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
			driver.quit(); /*드라이버 종료*/

		}

	}

	@Override
	public void case038(HttpServletRequest req) {
		// TODO 즐겨찾기 해제
		//LoginService.Login4(driver, base_url);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checker;
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
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

			//			즐겨찾기 해제 대상 탐색
			String bookmardChecked = (String) js.executeScript(
					"return $(\"div .ag-body-viewport span:contains('POC') > .ag-cell-value > span > [title='즐겨찾기']\").attr('class')",
					"");
			if (bookmardChecked.equalsIgnoreCase(BOOKMARK_UNCHECKED)) {
				throw new Exception("[" + methodName + "] 대상건이 없습니다.");
			}

			WebElement target = (WebElement) js.executeScript(
					"return $(\"div .ag-body-viewport span:contains('POC') > .ag-cell-value > span > [title='즐겨찾기']\").get(0)",
					"");
			target.click();

			/*즐겨찾기 해제 결과 확인*/
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

			if (target != null)
				throw new Exception("[" + new Object() {
				}.getClass().getEnclosingMethod().getName() + "] 즐겨찾기 해제 실패");

		} catch (Exception e) {
			js.executeScript("alert('" + e.getMessage() + "')", "");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} finally {
			driver.quit(); /*드라이버 종료*/

		}

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

	}

	@Override
	public void case065(HttpServletRequest req) {

	}

	@Override
	public void case066(HttpServletRequest req) {
		/*		
				해당 버전 다운로드
				1. 파일 목록 검색
				2. 파일 목록에서 버전이 2.0인 건을 검색
				3. 1.0 보다 큰건이 있을 경우
				   3-1. 대상 파일 우 클릭
				   3-2. 컨텍스트 메뉴에서 버전 클릭
				   3-3. 버전 목록 확인
				   3-4. 1.0 버전 선택
				   3-5. 다운로드 클릭
				   3-6. 거래 종료
				4. 1.0 보다 큰건이 없을 경우
				   4-1. 랜덤 파일명 생성및 변수 저장
				   4-2. 마우스 우클릭
				   4-3. 신규파일 메뉴 클릭
				   4-4. 텍스트 파일 라디오 버튼 클릭
				   4-5. 변수에 있는 파일명 입력
				   4-6. 확인버튼 클릭
				   4-7. 1번 부터 반복
				
				      
		*/
		
		//LoginService.Login4(driver, base_url);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//		액션 선언 및 바인딩
		Actions actions = new Actions(driver);
		
		boolean isVersionChecked = false;
		String fileName=null;
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		try {
			/***
			 * 1. 파일 목록 검색
			 */
			if (!SeleniumUtil.onloadCheck(driver, "$(\"div #tablev_toolbar\").get(0)"))
				throw new Exception("[" + methodName + "] 화면 출력이 완료되었지만, 대상이 존재하지 않습니다.");

			//			부서 문서함의 POC 폴더 선택
			WebElement deptElement = (WebElement) js.executeScript(	"return $(\"div#edrm-left ul#treeview .tree-root span.k-in:contains('부서 문서함')\").get(0)","");
			if (deptElement == null)
				throw new Exception("[" + methodName + "] 부서 문서함을 선택하지 못했습니다.");
			deptElement.click();

			if (!SeleniumUtil.onloadCheck(driver, "$(\"div #tablev_toolbar\").get(0)"))
				throw new Exception("[" + methodName + "] 화면 출력이 완료되었지만, 대상이 존재하지 않습니다.");

			//			폴더 선택
			WebElement targetFolderElement = (WebElement) js.executeScript(
					"return $(\"div .ag-body-viewport div[role='row'] :contains('POC')\").get(0)",
					"");
			if (targetFolderElement == null)
				throw new Exception("[" + methodName + "] 대상 폴더를 찾지 못했습니다.");
			//			액션 선언 및 바인딩
			actions.doubleClick(targetFolderElement).build().perform();

			if (!SeleniumUtil.onloadCheck(driver, "$(\"div #tablev_toolbar\").get(0)"))
				throw new Exception("[" + methodName + "] 화면 출력이 완료되었지만, 대상이 존재하지 않습니다.");

			do {

				/***
				 * 2. 파일 목록에서 버전이 1.0보다 큰건을 검색
				 */
				//검색 대상 건수 확인
				long elementCnt = (long)js.executeScript("return $(\"div .ag-body-viewport .ag-body-container [col-id='doc:Version']\").length", "");
				double baseVersion=1.0;
				

				WebElement targetFileElement=null;
				for(int i = 1;i<= elementCnt;i++) {
					//			순차 검색
					targetFileElement = (WebElement) js.executeScript("return $(\"div .ag-body-viewport .ag-body-container div[role='row']:nth-child("+i+")>[col-id='doc:Version']\").get(0)","0");
					if(StringUtil.NVL(targetFileElement.getText()).length()>0 && Double.parseDouble(targetFileElement.getText())> baseVersion){
						targetFileElement = (WebElement)js.executeScript("return $(\"div .ag-body-viewport .ag-body-container div[role='row']:nth-child("+i+")>[col-id='object_name']\").get(0)","0");
						fileName=targetFileElement.getText();
						System.out.println(fileName);
						isVersionChecked=true;
						break;
					}
				}

				if(isVersionChecked) {

					/***
					 * 3. 1.0 보다 큰건이 있을 경우
					 */
					actions.contextClick(targetFileElement).build().perform();;
					if (!SeleniumUtil.onloadCheck(driver, "$(\"#edrm-body div.ctx ul li.ctx-item:contains('속성')\").get(0)"))
						throw new Exception("[" + methodName + "] 컨텍스트메뉴 이벤트가 호출되었지만, 대상이 존재하지 않습니다.");

					WebElement versionElement = (WebElement)js.executeScript("return $(\"#edrm-body div.ctx ul li.ctx-item:contains('버전')\").get(0)", "");
					if(versionElement==null)
						throw new Exception("[" + methodName + "] 버전 메뉴가 존재하지 않습니다.");
					
//					3-2. 컨텍스트 메뉴에서 버전 클릭
					versionElement.click();
					if (!SeleniumUtil.onloadCheck(driver, "$(\"div[role='dialog'] :button :contains('닫기')\").get(0)"))
						throw new Exception("[" + methodName + "] 버전메뉴 이벤트가 호출되었지만, 대상이 존재하지 않습니다.");
					
//					3-3. 버전 목록 확인
					if(!SeleniumUtil.onloadCheck(driver, "$(\"div[role='dialog'] div#searchGrid div.ag-body-viewport div[role='row']\").get(0)"))
						throw new Exception("[" + methodName + "] 버전 목록이 없습니다.");
//					3-4. 1.0 버전 선택
//					3-5. 다운로드 클릭
					versionElement = (WebElement)js.executeScript("return $(\"div[role='dialog'] div#searchGrid div.ag-body-viewport div[role='row'] span :button:contains('다운로드')\").get(0)", "");
					versionElement.click();
//					3-6. 거래 종료
					if(!SeleniumUtil.onloadCheck(driver, "$(\"[role='alert']:contains('성공완료')\").get(0)")){
						throw new Exception("[" + methodName + "] 다운로드가 실패하였습니다.");
					}

				}else {
					/***
					 * 4. 1.0 보다 큰건이 없을 경우
					 */
					if(fileName==null) {
						//				4-1. 랜덤 파일명 생성및 변수 저장
						fileName="테스트파일_"+ETCUtil.randomHangulNameRtnThree();
					}
					//				4-2. 등록버튼 클릭
					targetFileElement = (WebElement)js.executeScript("return $(\"div#edrm-main div#edrm-right-sub :button span:contains('등록')\").get(0)","0");
					if(targetFileElement==null)
						throw new Exception("[" + methodName + "] 그리드가 존재하지 않습니다.");
					targetFileElement.click();
					if (!SeleniumUtil.onloadCheck(driver, "$(\"ul li.el-dropdown-menu__item:contains('신규 파일')\").get(0)"))
						throw new Exception("[" + methodName + "] 등록버튼 클릭 이벤트가 호출되었지만, 대상이 존재하지 않습니다.");

					//			4-3. 신규 파일 클릭
					targetFileElement = (WebElement)js.executeScript("return  $(\"ul li.el-dropdown-menu__item:contains('신규 파일')\").get(0)", "");
					targetFileElement.click();
					if(!SeleniumUtil.onloadCheck(driver, "$(\"div#edrm-body div[role='dialog'] span.dialog-footer :button> span:contains('취소') \").get(0)")) {
						throw new Exception("[" + methodName + "] 신규파일 클릭 이벤트가 호출되었지만, 대상이 존재하지 않습니다.");
					}

					//			4-4. 텍스트파일 클릭
					targetFileElement = (WebElement)js.executeScript("return $(\"div[role='dialog'] div[role='radiogroup'] span:contains('텍스트 파일')\").get(0)", "");
					targetFileElement.click();

					//			4-5. 변수에 있는 파일명 입력
					targetFileElement = (WebElement)js.executeScript("return $(\"div[role='dialog'] div.el-dialog__body :text\").get(0)", "");
					targetFileElement.clear();
					targetFileElement.sendKeys(fileName);

					//			4-6. 확인 버튼 클릭
					targetFileElement = (WebElement)js.executeScript("return $(\"div[role='dialog'] div.el-dialog__footer :button:contains('확인') \").get(0)", "");
					targetFileElement.click();
					
					if(!SeleniumUtil.onloadCheck(driver, "$(\"[role='alert']:contains('성공완료')\").get(0)")){
						targetFileElement = (WebElement)js.executeScript("return $(\"div#overWriteDialog :button span:contains('확인')\").get(0)", "");
						if(targetFileElement==null)
							throw new Exception("["+ methodName +"] 파일바꾸기 또는 덮어쓰기 다이얼로그 호출에 실패했습니다.");
						targetFileElement.click();
						if(!SeleniumUtil.onloadCheck(driver, "$(\"[role='alert']:contains('성공완료')\").get(0)"))
							throw new Exception("[" + methodName + "] 새파일 등록 요청이 실패하였습니다.");
					}
				
				}
			}while(!isVersionChecked);
			
		} catch (Exception e) {
			js.executeScript("alert('" + e.getMessage() + "')", "");
			System.out.println(e.getMessage());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} finally {
			driver.quit(); /*드라이버 종료*/

		}
		
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
		/*
			문서 이력 확인
			1. 대상 파일 우 클릭
			2. 컨텍스트 메뉴에서 세부정보 클릭
			3. 이력 탭 클릭
		 */

		//LoginService.Login4(driver, base_url);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checker;

		//		액션 선언 및 바인딩
		Actions actions = new Actions(driver);
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		try {
			
			if (!SeleniumUtil.onloadCheck(driver, "$(\"div #tablev_toolbar\").get(0)"))
				throw new Exception("[" + methodName + "화면 출력이 완료되었지만, 대상이 존재하지 않습니다.");

			//			부서 문서함의 POC 폴더 선택
			WebElement deptElement = (WebElement) js.executeScript(	"return $(\"div#edrm-left ul#treeview .tree-root span.k-in:contains('부서 문서함')\").get(0)","");
			if (deptElement == null)
				throw new Exception("[" + methodName + "] 부서 문서함을 선택하지 못했습니다.");
			deptElement.click();

			if (!SeleniumUtil.onloadCheck(driver, "$(\"div #tablev_toolbar\").get(0)"))
				throw new Exception("[" + methodName + "화면 출력이 완료되었지만, 대상이 존재하지 않습니다.");

			//			폴더 선택
			WebElement targetFolderElement = (WebElement) js.executeScript(
					"return $(\"div .ag-body-viewport div[role='row'] :contains('POC')\").get(0)",
					"");
			if (targetFolderElement == null)
				throw new Exception("[" + methodName + "] 대상 폴더를 찾지 못했습니다.");
			//			액션 선언 및 바인딩
			actions.doubleClick(targetFolderElement).build().perform();

			if (!SeleniumUtil.onloadCheck(driver, "$(\"div #tablev_toolbar\").get(0)"))
				throw new Exception("[" + methodName + "화면 출력이 완료되었지만, 대상이 존재하지 않습니다.");

			//			대상파일 선택
			WebElement targetFileElement = (WebElement) js.executeScript(
					"return $(\"div .ag-body-viewport span:contains('inzent_logo.jpg') > .ag-cell-value > span \").get(0)",
					"");
			if (targetFileElement == null)
				throw new Exception("[" + methodName + "] 대상 파일을 찾지 못했습니다.");
			actions = new Actions(driver);
			actions.contextClick(targetFileElement).build().perform();

			if (!SeleniumUtil.onloadCheck(driver,
					"$(\"div#edrm-main ul.ctx-menu li.ctx-item:contains('속성')\").get(0)"))
				throw new Exception("[" + methodName + "화면 출력이 완료되었지만, 대상이 존재하지 않습니다.");

			/*컨텍스트메뉴 생성 확인*/
			WebElement contextMenuElement = (WebElement) js.executeScript(
					"return $(\"div#edrm-main ul.ctx-menu li.ctx-item:contains('이력')\").parent().get(0)",
					"");
			if (contextMenuElement == null)
				throw new Exception("[" + methodName + "] 이력 메뉴 선택 실패");
			contextMenuElement.click();

			if (!SeleniumUtil.onloadCheck(driver,
					"$(\"div .el-dialog__footer > span > button :contains('닫기')\").get(0)"))
				throw new Exception("[" + methodName + "화면 출력이 완료되었지만, 대상이 존재하지 않습니다.");
			
			//			그리드 내 데이터가 1건이상 존재하는지 확인
			WebElement rowElement = (WebElement) js.executeScript(
					"return $(\"div [role='dialog'] div.ag-body-container div[role='row']:first\").get(0)",
					"");
			if (rowElement == null)
				throw new Exception("case[" + methodName + "] 이력 조회 실패");

		} catch (Exception e) {
			js.executeScript("alert('" + e.getMessage() + "')", "");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} finally {
			driver.quit(); /*드라이버 종료*/

		}
	}

	@Override
	public void case075(HttpServletRequest req) {

	}

	@Override
	public void case076(HttpServletRequest req) {

	}

	@Override
	public void case077(HttpServletRequest req) {

	}

	@Override
	public void case078(HttpServletRequest req) {

	}

}
