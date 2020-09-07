package com.inzent.selenium.repository;

import java.util.List;

import javax.persistence.Column;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.inzent.selenium.dto.TestCaseDTO;
import com.inzent.selenium.entity.TestCase;
import com.inzent.selenium.entity.TestCaseAttr;

@Repository
public interface TestRepository extends JpaRepository<TestCase, Long> {

    <E extends TestCase> E save(@NonNull E entity);

    List<TestCase> findAll();

    Page<TestCase> findAll(Pageable pageable);

    long count();

    List<TestCase> findAllByVersion(String version);
    
    @Query(value = "select new com.inzent.selenium.dto.TestCaseDTO(c.testId, c.mainCategory, c.middleCategory, c.smallCategory, c.procedure, c.beforeProcedure, c.result, c.developer, c.startdate, c.enddate, c.time, c.version, ta.attrName, ta.attrValue, ta.description) from TestCase c join c.testCaseAttr ta where c.version = :version and ta.attrName = :attrName")
    List<TestCaseDTO> findAllByVersionForJpql(@Param("version") String version, @Param("attrName") String attrname);

    List<TestCase> findAllByVersion(String version, Pageable pageable);

    @Query(value = "select new com.inzent.selenium.dto.TestCaseDTO(c.testId, c.mainCategory, c.middleCategory, c.smallCategory, c.procedure, c.beforeProcedure, c.result, c.developer, c.startdate, c.enddate, c.time, c.version, ta.attrName, ta.attrValue, ta.description) from TestCase c left join c.testCaseAttr ta where c.testId = ta.testId and c.testId = :testId and c.version = :version and ta.attrName = :attrName")
    TestCaseDTO findByTestIdAndVersionAndAttrValue(@Param("testId") String testId, @Param("version") String version, @Param("attrName") String attrName);
    
    TestCase findByTestId(String testId);
    
    @Query(value = "select c from TestCaseAttr c where c.testId = :testId and c.attrName = :attrName")
    TestCaseAttr findByTestCaseAttr(@Param("testId") String testId, @Param("attrName") String attrName);
}
