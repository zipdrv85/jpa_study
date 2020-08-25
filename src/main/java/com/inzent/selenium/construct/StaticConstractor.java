package com.inzent.selenium.construct;

import java.util.List;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Configuration;

import com.inzent.selenium.entity.Env;
import com.inzent.selenium.entity.EnvAttr;
import com.inzent.selenium.service.EnvService;

@Slf4j
@Getter
@Configuration
public class StaticConstractor {
	
	//NOTE AUTOWIRED DI CHANGE
	public final EnvService envService;

	public StaticConstractor(EnvService envService) { 
		this.envService = envService;

		Env env4 = envService.findByVersionAndEnabled("4.0", true);

		if(env4 != null) {		
			envid4 = env4.getEnvid();
			version4 = env4.getVersion();
			enabled4 = env4.isEnabled();
			url4 = env4.getUrl();
			id4 = env4.getId();
			password4 = env4.getPassword();
			description4 = env4.getDescription();
			envid4Attr = env4.getEnvAttr();
		}
		
		Env env6 = envService.findByVersionAndEnabled("6.0", true);
		
		if(env6 != null) {
			envid6 = env6.getEnvid();
			version6 = env6.getVersion();
			enabled6 = env6.isEnabled();
			url6 = env6.getUrl();
			id6 = env6.getId();
			password6 = env6.getPassword();
			description6 = env6.getDescription();
			envid6Attr = env6.getEnvAttr();
		}
		
		log.debug(envid4);
		log.debug(version4);
		log.debug(id4);
		log.debug(password4);
		log.debug(description4);
	}
	
	public static String envid4;
	public static String version4;
	public static boolean enabled4;
	public static String url4;
	public static String id4;
	public static String password4;
	public static String description4;
	public static List<EnvAttr> envid4Attr;

	public static String envid6;
	public static String version6;
	public static boolean enabled6;
	public static String url6;
	public static String id6;
	public static String password6;
	public static String description6;
	public static List<EnvAttr> envid6Attr;

}
