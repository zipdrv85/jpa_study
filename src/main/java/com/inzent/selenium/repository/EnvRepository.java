package com.inzent.selenium.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inzent.selenium.entity.Env;

@Repository
public interface EnvRepository extends CrudRepository<Env, Integer> {
	
	List<Env> findAll();
	
	Env findAllByENVID(String envid);
}
