package com.inzent.selenium.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Table(name = "testCaseAttr")
@Entity
@Getter
@Setter
public class TestCaseAttr implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestCaseAttr() {}
	
	public TestCaseAttr(TestCaseAttr testCaseAttrParam) {
		this.testId = testCaseAttrParam.getTestId();
		this.attrName = testCaseAttrParam.getAttrName();
		this.attrValue = testCaseAttrParam.getAttrValue();
		this.description = testCaseAttrParam.getDescription();		
	}
		
	@NonNull
	@Id
	@Column(name = "test_id", nullable = false, updatable = false)
	private String testId;		//테스트아이디
	
	@NonNull
	@Id
	@Column(name = "ATTR_NAME", nullable = false, updatable = false)
	private String attrName;	//속성명

	private String attrValue;	//속성이름
	
	private String description;	//속성 설명

	@Override
	public String toString() {
		return "TestCaseAttr [testId=" + testId + ", attrName=" + attrName
				+ ", attrValue=" + attrValue + ", description=" + description
				+ "]";
	}

	public TestCaseAttr(@NonNull String testId, @NonNull String attrName,
			String attrValue, String description) {
		super();
		this.testId = testId;
		this.attrName = attrName;
		this.attrValue = attrValue;
		this.description = description;
	}

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "TEST_ID")
	//@JsonBackReference
	//private TestCase testCase;
	
	//연관관계 메소드 (FK 보단 비즈니스 관점에서 위치한다)
	/*
	public void setTestCase(TestCase testCase) {
		this.testCase = testCase;
		testCase.getTestCaseAttr().add(this);
	}*/
}
