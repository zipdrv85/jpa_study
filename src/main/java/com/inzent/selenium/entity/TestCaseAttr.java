package com.inzent.selenium.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

@Table(name = "TESTCASEATTR")
@Entity
@Getter
public class TestCaseAttr implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TestCaseAttr() {}
		
	//@NonNull
	@Id
	@Column(name = "TEST_ID", nullable = false, updatable = false)
	private String TEST_ID;		//테스트아이디
	
	//@NonNull
	@Id
	@Column(name = "ATTR_NAME", nullable = false, updatable = false)
	private String ATTR_NAME;	//속성명

	private String ATTR_VALUE;	//속성이름

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEST_ID")
	private TestCase testCase;
	
	//연관관계 메소드 (FK 보단 비즈니스 관점에서 위치한다)
	public void setTestCase(TestCase testCase) {
		this.testCase = testCase;
		testCase.getTestCaseAttr().add(this);
	}

	@Override
	public String toString() {
		return "TestCaseAttr [TEST_ID=" + TEST_ID + ", ATTR_NAME=" + ATTR_NAME + ", ATTR_VALUE=" + ATTR_VALUE
				+ ", testCase=" + testCase + "]";
	}

}
