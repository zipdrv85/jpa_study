package com.inzent.selenium.dto;

import com.inzent.selenium.entity.Env;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class EnvResponseDto {

	private String ENVID;
	private String URL;
	private String ID;
	private String PASSWORD;
	private boolean ENABLED;
	private String DESCRIPTION;
	
	public EnvResponseDto() {}
	
	public EnvResponseDto(Env env) {
		ENVID = env.getENVID();
		URL = env.getURL();
		ID = env.getID();
		PASSWORD = env.getPASSWORD();
		ENABLED = env.isENABLED();
		DESCRIPTION = env.getDESCRIPTION();
	}
	
}
