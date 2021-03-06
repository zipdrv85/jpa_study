package com.inzent.selenium.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "testCase")
@Entity
@Getter
@Setter
@Data
public class TestCase implements Persistable<UUID>{
	
	public TestCase() {}
	
	public TestCase(String tEST_ID, String mAIN_CATEGORY, String mIDDLE_CATEGORY, String sMALL_CATEGORY,
			String pROCEDURE, String bEFORE_PROCEDURE, String rESULT, String dEVELOPER, String sTARTDATE, String eNDDATE,
			String tIME, String vERSION) {
		super();
		testId = tEST_ID;
		mainCategory = mAIN_CATEGORY;
		middleCategory = mIDDLE_CATEGORY;
		smallCategory = sMALL_CATEGORY;
		procedure = pROCEDURE;
		beforeProcedure = bEFORE_PROCEDURE;
		result = rESULT;
		developer = dEVELOPER;
		startdate = sTARTDATE;
		enddate = eNDDATE;
		time = tIME;
		version = vERSION;
	}
	
	@Id
	@Column(name = "test_Id", nullable = false)
	private String testId;			//테스트아이디
	@Column(name = "main_Category")
	private String mainCategory;	//대분류
	@Column(name = "middle_Category")
	private String middleCategory;	//중분류
	@Column(name = "small_Category")
	private String smallCategory;	//소분류
	@Column(name = "procedure")
	private String procedure;		//수행 절차
	@Column(name = "before_Procedure")
	private String beforeProcedure;	//사전작업
	@Column(name = "result")
	private String result;			//기대값
	@Column(name = "developer")
	private String developer;		//개발자
	@Column(name = "startdate")
	private String startdate;			//시작일시
	@Column(name = "enddate")
	private String enddate;			//완료일시
	@Column(name = "time")
	private String time;			//소요시간
	@Column(name = "version")
	private String version;			//버전
	
	//@OneToMany(mappedBy = "testCase")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "test_id")
	@JsonManagedReference
	List<TestCaseAttr> testCaseAttr = new ArrayList<TestCaseAttr>();

	@Override
	public String toString() {
		return "TestListModel [TEST_ID=" + testId + ", MAIN_CATEGORY=" + mainCategory + ", MIDDLE_CATEGORY="
				+ middleCategory + ", SMALL_CATEGORY=" + smallCategory + ", PROCEDURE=" + procedure
				+ ", BEFORE_PROCEDURE=" + beforeProcedure + ", RESULT=" + result + ", DEVELOPER=" + developer
				+ ", STARTDATE=" + startdate + ", ENDDATE=" + enddate + ", TIME=" + time + ", VERSION=" + version + "]";
	}
	
	public void addTestCaseAttrs(String testId, List<TestCaseAttr> testCaseAttrs) {
		this.testId = testId;
		this.testCaseAttr.addAll(testCaseAttrs);
	}
	
	public void addNewTestCaseAttr(String testId, TestCaseAttr testCaseAttr) {
		this.testId = testId;
		this.testCaseAttr.add(testCaseAttr);
	}

	@Override
	public UUID getId() { return null; }

	@Override
	public boolean isNew() { return true; }
}
