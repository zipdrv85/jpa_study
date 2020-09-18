package com.inzent.selenium.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inzent.selenium.entity.Env;

public interface MemberRepository extends JpaRepository<Env, Long> {
	
}