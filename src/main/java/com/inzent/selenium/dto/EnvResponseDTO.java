package com.inzent.selenium.dto;

import com.inzent.selenium.entity.Env;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class EnvResponseDTO {

	private String envid;
	private String url;
	private String id;
	private String password;
	private boolean enabled;
	private String description;
	
	public EnvResponseDTO() {}
	
	public EnvResponseDTO(Env env) {
		envid = env.getEnvid();
		url = env.getUrl();
		id = env.getId();
		password = env.getPassword();
		enabled = env.isEnabled();
		description = env.getDescription();
	}
	
}
