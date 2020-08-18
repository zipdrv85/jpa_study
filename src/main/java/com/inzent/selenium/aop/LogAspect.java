package com.inzent.selenium.aop;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

	@Around("execution(* com.inzent.selenium.service..*.*(..))")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		
		log.info("start Aop log -----------------------------------");
		log.info(pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
		Object result = pjp.proceed();
		log.info("end Aop log -----------------------------------");
		log.info(pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());

		return result;
	}
	
}
