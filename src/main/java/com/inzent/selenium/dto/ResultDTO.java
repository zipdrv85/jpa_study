package com.inzent.selenium.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDTO {

	private String resultid;
	private String executeMehtod;
	private String executeTime;
	private String executeClass;
	private String imagePath;
	private String version;
	private String className;
	private String testNumber;
	private String testId;
	private String attrName;	//속성명
	private String attrValue;	//속성이름
	private String description;	//속성 설명
	
	public ResultDTO() {}

	@Override
	public String toString() {
		return "ResultDTO [resultid=" + resultid + ", executeMehtod="
				+ executeMehtod + ", executeTime=" + executeTime
				+ ", executeClass=" + executeClass + ", imagePath=" + imagePath
				+ ", version=" + version + ", className=" + className
				+ ", testNumber=" + testNumber + ", testId=" + testId
				+ ", attrName=" + attrName + ", attrValue=" + attrValue
				+ ", description=" + description + "]";
	}

	public ResultDTO(String resultid, String executeMehtod, String executeTime,
			String executeClass, String imagePath, String version,
			String className, String testNumber, String testId,
			String attrName, String attrValue, String description) {
		super();
		this.resultid = resultid;
		this.executeMehtod = executeMehtod;
		this.executeTime = executeTime;
		this.executeClass = executeClass;
		this.imagePath = imagePath;
		this.version = version;
		this.className = className;
		this.testNumber = testNumber;
		this.testId = testId;
		this.attrName = attrName;
		this.attrValue = attrValue;
		this.description = description;
	}
}
