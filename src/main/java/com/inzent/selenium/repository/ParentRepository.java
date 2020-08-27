package com.inzent.selenium.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inzent.selenium.entity.Env;
import com.inzent.selenium.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {

}
