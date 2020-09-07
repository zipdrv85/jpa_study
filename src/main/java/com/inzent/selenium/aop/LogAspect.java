package com.inzent.selenium.aop;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.inzent.selenium.entity.Result;
import com.inzent.selenium.service.ResultService;

@Slf4j
@Aspect
@Component
public class LogAspect {

	private final ResultService resultService; 

	public LogAspect(ResultService resultService) {
		this.resultService = resultService;
	}
	
    //PointCut의 속성에 핵심코드의 어느 부분까지 공통 기능을 사용하겟다고 명시
    //@Pointcut("expression=within(com.inzent.selenium.service.*)")
    //private void publicTarget() {}
	
	//@Around("within(com.inzent.selenium.controller.*)")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

		log.info("start Aop log -----------------------------------");
		log.info(pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
		Object result = pjp.proceed();
		log.info("end Aop log -----------------------------------");
		log.info(pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());

		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
		
		Result resultEntity = new Result();
		resultEntity.setExecuteTime(""+secDiffTime);
		resultEntity.setExecuteMehtod(pjp.getSignature().getName());
		
		resultService.saveAndFlush(resultEntity);

		return result;
	}
	
}
