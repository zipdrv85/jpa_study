package com.inzent.selenium.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;

@Table(name = "TESTCASE")
@Entity
@Getter
public class TestCase {
	
	private TestCase() {}
	
	public TestCase(String tEST_ID, String mAIN_CATEGORY, String mIDDLE_CATEGORY, String sMALL_CATEGORY,
			String pROCEDURE, String bEFORE_PROCEDURE, String rESULT, String dEVELOPER, String sTARTDATE, String eNDDATE,
			String tIME, String vERSION) {
		super();
		TEST_ID = tEST_ID;
		MAIN_CATEGORY = mAIN_CATEGORY;
		MIDDLE_CATEGORY = mIDDLE_CATEGORY;
		SMALL_CATEGORY = sMALL_CATEGORY;
		PROCEDURE = pROCEDURE;
		BEFORE_PROCEDURE = bEFORE_PROCEDURE;
		RESULT = rESULT;
		DEVELOPER = dEVELOPER;
		STARTDATE = sTARTDATE;
		ENDDATE = eNDDATE;
		TIME = tIME;
		VERSION = vERSION;
	}
	
	@Id
	private String TEST_ID;			//테스트아이디
	private String MAIN_CATEGORY;	//대분류
	private String MIDDLE_CATEGORY;	//중분류
	private String SMALL_CATEGORY;	//소분류
	private String PROCEDURE;		//수행 절차
	private String BEFORE_PROCEDURE;	//사전작업
	private String RESULT;			//기대값
	private String DEVELOPER;		//개발자
	private String STARTDATE;			//시작일시
	private String ENDDATE;			//완료일시
	private String TIME;			//소요시간
	private String VERSION;			//버전
	
	@OneToMany(mappedBy = "testCase")
	List<TestCaseAttr> testCaseAttr = new ArrayList<>();

	@Override
	public String toString() {
		return "TestListModel [TEST_ID=" + TEST_ID + ", MAIN_CATEGORY=" + MAIN_CATEGORY + ", MIDDLE_CATEGORY="
				+ MIDDLE_CATEGORY + ", SMALL_CATEGORY=" + SMALL_CATEGORY + ", PROCEDURE=" + PROCEDURE
				+ ", BEFORE_PROCEDURE=" + BEFORE_PROCEDURE + ", RESULT=" + RESULT + ", DEVELOPER=" + DEVELOPER
				+ ", STARTDATE=" + STARTDATE + ", ENDDATE=" + ENDDATE + ", TIME=" + TIME + ", VERSION=" + VERSION + "]";
	}
}
