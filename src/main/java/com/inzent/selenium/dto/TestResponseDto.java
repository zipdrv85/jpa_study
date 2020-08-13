package com.inzent.selenium.dto;

import java.util.Date;

import com.inzent.selenium.entity.TestCase;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TestResponseDto {

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
	
	public TestResponseDto() {}
	
	public TestResponseDto(TestCase testModel) {
		TEST_ID = testModel.getTEST_ID();
		MAIN_CATEGORY = testModel.getMAIN_CATEGORY();
		MIDDLE_CATEGORY = testModel.getMAIN_CATEGORY();
		SMALL_CATEGORY = testModel.getSMALL_CATEGORY();
		PROCEDURE = testModel.getPROCEDURE();
		BEFORE_PROCEDURE = testModel.getBEFORE_PROCEDURE();
		RESULT = testModel.getRESULT();
		DEVELOPER = testModel.getDEVELOPER();
		STARTDATE = testModel.getSTARTDATE();
		ENDDATE = testModel.getENDDATE();
		TIME = testModel.getTIME();
		VERSION = testModel.getVERSION();
	}
	
}
