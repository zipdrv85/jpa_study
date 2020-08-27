package com.inzent.selenium.vo;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@Data
public class EnvRequestVO {

	private String envid;
	private String attrName;
	private String attrValue;
	private List<EnvRequestVO> envRequestVOList;
	
	public EnvRequestVO() {}

	@Override
	public String toString() {
		return "EnvRequestVO [envid=" + envid + ", attrName=" + attrName
				+ ", attrValue=" + attrValue + ", envRequestVOList="
				+ envRequestVOList + "]";
	}
}
