package com.inzent.selenium.service;

import java.util.List;

import javax.persistence.Column;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.inzent.selenium.conf.SeleniumWebDriverConfig;
import com.inzent.selenium.construct.StaticConstractor;
import com.inzent.selenium.entity.Child;
import com.inzent.selenium.entity.Env;
import com.inzent.selenium.entity.EnvAttr;
import com.inzent.selenium.entity.Parent;
import com.inzent.selenium.repository.EnvRepository;

@Slf4j
@Service
public class EnvService {

	//NOTE AUTOWIRED DI CHANGE
	private final EnvRepository envRepository;

	public EnvService (EnvRepository envRepository) {
		this.envRepository = envRepository;
	}
	
	@Transactional(readOnly = true)
	public List<Env> findAll() {		
		return envRepository
				.findAll();
	}
	
	@Transactional(readOnly = true)
	public Env findAllByEnvid(Long envid) {
		return envRepository
				.findByEnvid(envid);
	}
	
	@Transactional(readOnly = true)
	public Env findAllByUrl(Long envid) {
		return envRepository
				.findByEnvid(envid);
	}
	
	@Transactional(readOnly = true)
	public EnvAttr findAllByEnvidAttr(Long envid) {
		//return (EnvAttr) envRepository
				//.findByEnvid(envid)
				//.getEnvAttr();
		return null;
	}
	
	@Transactional(readOnly = true)
	public List<Env> findByVersionAndEnabled(String version, Boolean enabled) {
		return envRepository
				.findByVersionAndEnabled(version, enabled);
	}

	@Transactional
	public Env save(Env env) {
		log.debug("envService save");
		return envRepository.save(env);
	}
	
	@Transactional
	public Env saveEnv(Env paramEnv) {	

		Env env = envRepository.findByEnvid(paramEnv.getEnvid());
		
		log.debug("=================================================");
		log.debug(env.toString());
		log.debug(paramEnv.toString());
		log.debug("=================================================");
		
		//BeanUtils.copyProperties(paramEnv, env, "envAttr");
		//env.addEnv(paramEnv);
		
		log.debug("=================================================");
		log.debug(env.toString());
		log.debug("=================================================");
		
		Env rtnEnv = envRepository.saveAndFlush(env);
		
		//static constractor Value Change
		//StaticConstractor.setStaticConstractor(rtnEnv);	
		
		return rtnEnv;
	}

	@Transactional
	public Env saveEnvAttrs(Long envid, String[] attrName, String[] attrValue) {

		Env env = envRepository.findByEnvid(envid);

		/*
		List<EnvAttr> envAttrList = env.getEnvAttr();

		envAttrList.forEach(e -> {
			int i = envAttrList.indexOf(e);
			e.setEnvid(envid);
			e.setAttrName(attrName[i]);
			e.setAttrValue(attrValue[i]);
		});

		env.addEnvAttrs(envid, envAttrList);
		*/

		Env rtnEnv = envRepository.saveAndFlush(env);
		
		//static constractor Value Change
		//StaticConstractor.setStaticConstractor(rtnEnv);
		
		return rtnEnv;
	}
}

