package com.inzent.selenium.dto;

import lombok.Getter;

import com.inzent.selenium.entity.TestCase;

@Getter
public class TestResponseDto {

	private String testId;			//테스트아이디
	private String mainCategory;	//대분류
	private String middleCategory;	//중분류
	private String smallCategory;	//소분류
	private String procedure;		//수행 절차
	private String beforeProcedure;	//사전작업
	private String result;			//기대값
	private String developer;		//개발자
	private String startdate;			//시작일시
	private String enddate;			//완료일시
	private String time;			//소요시간
	private String version;			//버전
	
	public TestResponseDto() {}
	
	public TestResponseDto(TestCase testModel) {
		testId = testModel.getTestId();
		mainCategory = testModel.getMainCategory();
		middleCategory = testModel.getMainCategory();
		smallCategory = testModel.getSmallCategory();
		procedure = testModel.getProcedure();
		beforeProcedure = testModel.getBeforeProcedure();
		result = testModel.getResult();
		developer = testModel.getDeveloper();
		startdate = testModel.getStartdate();
		enddate = testModel.getEnddate();
		time = testModel.getTime();
		version = testModel.getVersion();
	}
	
}
