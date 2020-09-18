package com.inzent.selenium.construct;

import java.util.List;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Configuration;

import com.inzent.selenium.entity.Env;
import com.inzent.selenium.entity.EnvAttr;
import com.inzent.selenium.service.EnvAttrService;
import com.inzent.selenium.service.EnvService;

@Slf4j
@Getter
@Configuration
public class StaticConstractor {
	
	//NOTE AUTOWIRED DI CHANGE
	private EnvAttrService envAttrService;
	private EnvService envService;

	public StaticConstractor(EnvAttrService envAttrService, EnvService envService) { 
		this.envAttrService = envAttrService;
		this.envService = envService;
		
		List<EnvAttr> envAttr = envAttrService.findAll();
		
		envAttr.forEach(e -> {
			Env env = envService.findAllByEnvid(e.getEnvid());

			if( "4.0".equals(env.getVersion()) && env.isEnabled() && !env.isIsadmin() ) {
				envid4_user = env.getEnvid();
				version4_user = env.getVersion();
				enabled4_user = env.isEnabled();
				url4_user = env.getUrl();
				id4_user = env.getId();
				password4_user = env.getPassword();
				description4_user = e.getDescription();
				envid4Attr_user = envAttr;
			} else if( "4.0".equals(env.getVersion()) && env.isEnabled() && env.isIsadmin() ) {
				envid4_user = e.getEnvid();
				version4_user = env.getVersion();
				enabled4_user = env.isEnabled();
				url4_user = env.getUrl();
				id4_user = env.getId();
				password4_user = env.getPassword();
				description4_user = e.getDescription();
				envid4Attr_user = envAttr;
			} else if( "6.0".equals(env.getVersion()) && env.isEnabled() && !env.isIsadmin() ) {
				envid6_user = env.getEnvid();
				version6_user = env.getVersion();
				enabled6_user = env.isEnabled();
				url6_user = env.getUrl();
				id6_user = env.getId();
				password6_user = env.getPassword();
				description6_user = e.getDescription();
				envid6Attr_user = envAttr;
			} else if( "6.0".equals(env.getVersion()) && env.isEnabled() && env.isIsadmin() ) {
				envid6_user = e.getEnvid();
				version6_user = env.getVersion();
				enabled6_user = env.isEnabled();
				url6_user = env.getUrl();
				id6_user = env.getId();
				password6_user = env.getPassword();
				description6_user = e.getDescription();
				envid6Attr_user = envAttr;
			} 
		});
		
		log.debug(""+envid4_user);
		log.debug(version4_user);
		log.debug(""+enabled4_user);
		log.debug(url4_user);
		log.debug(id4_user);
		log.debug(password4_user);
		log.debug(description4_user);
		if(envid4Attr_user != null) {
			log.debug(envid4Attr_user.toString());
		}
		
		log.debug(""+envid6_user);
		log.debug(version6_user);
		log.debug(""+enabled6_user);
		log.debug(url6_user);
		log.debug(id6_user);
		log.debug(password6_user);
		log.debug(description6_user);
		if(envid6Attr_user != null) {
			log.debug(envid6Attr_user.toString());
		}
	}
	
	public static void setStaticConstractor(EnvAttr envAttr) {
		
		log.debug(envAttr.toString());

		Env env = envAttr.getEnv();
		if("4.0".equals(env.getVersion())) {
			if(!env.isIsadmin()) {
				envid4_user = env.getEnvid();
				version4_user = env.getVersion();
				enabled4_user = env.isEnabled();
				url4_user = env.getUrl();
				id4_user = env.getId();
				password4_user = env.getPassword();
				description4_user = env.getDescription();
				envid4Attr_user = env.getEnvAttr();
			} else if(env.isIsadmin()) {
				envid4_admin = env.getEnvid();
				version4_admin = env.getVersion();
				enabled4_admin = env.isEnabled();
				url4_admin = env.getUrl();
				id4_admin = env.getId();
				password4_admin = env.getPassword();
				description4_admin = env.getDescription();
				envid4Attr_admin = env.getEnvAttr();
			}
		}
		
		if("6.0".equals(env.getVersion())) {

			if(!env.isIsadmin()) {
				envid6_user = env.getEnvid();
				version6_user = env.getVersion();
				enabled6_user = env.isEnabled();
				url6_user = env.getUrl();
				id6_user = env.getId();
				password6_user = env.getPassword();
				description6_user = env.getDescription();
				envid6Attr_user = env.getEnvAttr();
			} else if(env.isIsadmin()) {
				envid6_admin = env.getEnvid();
				version6_admin = env.getVersion();
				enabled6_admin = env.isEnabled();
				url6_admin = env.getUrl();
				id6_admin = env.getId();
				password6_admin = env.getPassword();
				description6_admin = env.getDescription();
				envid6Attr_admin = env.getEnvAttr();
			}
		}
		
		log.debug(""+envid4_user);
		log.debug(version4_user);
		log.debug(""+enabled4_user);
		log.debug(url4_user);
		log.debug(id4_user);
		log.debug(password4_user);
		log.debug(description4_user);
		if(envid4Attr_user != null) {
			log.debug(envid4Attr_user.toString());
		}
		
		log.debug(""+envid6_user);
		log.debug(version6_user);
		log.debug(""+enabled6_user);
		log.debug(url6_user);
		log.debug(id6_user);
		log.debug(password6_user);
		log.debug(description6_user);
		if(envid6Attr_user != null) {
			log.debug(envid6Attr_user.toString());
		}
	}

	public static Long envid4_user;
	public static String version4_user;
	public static boolean enabled4_user;
	public static String url4_user;
	public static String id4_user;
	public static String password4_user;
	public static String description4_user;
	public static List<EnvAttr> envid4Attr_user;
	
	public static Long envid4_admin;
	public static String version4_admin;
	public static boolean enabled4_admin;
	public static String url4_admin;
	public static String id4_admin;
	public static String password4_admin;
	public static String description4_admin;
	public static List<EnvAttr> envid4Attr_admin;

	public static Long envid6_user;
	public static String version6_user;
	public static boolean enabled6_user;
	public static String url6_user;
	public static String id6_user;
	public static String password6_user;
	public static String description6_user;
	public static List<EnvAttr> envid6Attr_user;
	
	public static Long envid6_admin;
	public static String version6_admin;
	public static boolean enabled6_admin;
	public static String url6_admin;
	public static String id6_admin;
	public static String password6_admin;
	public static String description6_admin;
	public static List<EnvAttr> envid6Attr_admin;

}
