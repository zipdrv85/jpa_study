package com.inzent.selenium.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inzent.selenium.entity.Env;

@Repository
public interface EnvRepository extends JpaRepository<Env, Integer> {
	
	List<Env> findAll();
	
	Env findByEnvid(String envid);
	
	Env findByUrl(String url);
}
