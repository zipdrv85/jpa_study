package com.inzent.selenium.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestCaseDto {

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
	private String attrName;	//속성명
	private String attrValue;	//속성이름
	private String description;	//속성 설명
	
	public TestCaseDto() {}
	
	public TestCaseDto(String testId, String mainCategory,
			String middleCategory, String smallCategory, String procedure,
			String beforeProcedure, String result, String developer,
			String startdate, String enddate, String time, String version,
			String attrName, String attrValue, String description) {
		super();
		this.testId = testId;
		this.mainCategory = mainCategory;
		this.middleCategory = middleCategory;
		this.smallCategory = smallCategory;
		this.procedure = procedure;
		this.beforeProcedure = beforeProcedure;
		this.result = result;
		this.developer = developer;
		this.startdate = startdate;
		this.enddate = enddate;
		this.time = time;
		this.version = version;
		this.attrName = attrName;
		this.attrValue = attrValue;
		this.description = description;
	}

	@Override
	public String toString() {
		return "TestCaseDto [testId=" + testId + ", mainCategory="
				+ mainCategory + ", middleCategory=" + middleCategory
				+ ", smallCategory=" + smallCategory + ", procedure="
				+ procedure + ", beforeProcedure=" + beforeProcedure
				+ ", result=" + result + ", developer=" + developer
				+ ", startdate=" + startdate + ", enddate=" + enddate
				+ ", time=" + time + ", version=" + version + ", attrName="
				+ attrName + ", attrValue=" + attrValue + ", description="
				+ description + "]";
	}
}
