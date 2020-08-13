package com.inzent.selenium.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.inzent.selenium.entity.TestCase;

@Repository
public interface TestRepository extends JpaRepository<TestCase, Long>{

    <E extends TestCase> E save(@NonNull E entity);

    List<TestCase> findAll();

    long count();
    
    List<TestCase> findAllByVERSION(String version);
}