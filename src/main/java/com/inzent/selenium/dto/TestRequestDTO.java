package com.inzent.selenium.dto;

import java.util.Date;

import com.inzent.selenium.entity.TestCase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestRequestDTO {

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
	
	
    public TestCase toEntity(){
        return new TestCase(TEST_ID, MAIN_CATEGORY, MIDDLE_CATEGORY, SMALL_CATEGORY, PROCEDURE, BEFORE_PROCEDURE, RESULT, DEVELOPER, STARTDATE, ENDDATE, TIME, VERSION);
    }
}
