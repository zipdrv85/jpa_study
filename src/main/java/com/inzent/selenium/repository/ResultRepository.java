package com.inzent.selenium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inzent.selenium.dto.ResultDTO;
import com.inzent.selenium.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
	
    @Query(value = "select new com.inzent.selenium.dto.ResultDTO(c.resultid, c.executeMehtod, c.executeTime, c.executeClass, c.imagePath, c.version, c.className, c.testNumber, c.testId, ta.attrName, ta.attrValue, ta.description) from Result c join c.resultAttr ta where c.testId = :testId and ta.attrName = :attrName")
    ResultDTO findByTestIdJpql(@Param("testId") String testId, @Param("attrName") String attrname);
    
    Result findByTestId(String testId);
}
