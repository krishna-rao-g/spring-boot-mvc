package com.spring.mvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	// is combination of before + after
	// @annotation(LogExecutionTime) -> this is my pointcut
	// @Around - is my advice
	// @aspect LoggingAspect 
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		// it will invoke the method
		Object proceed = joinPoint.proceed();

		// it will have the end time
		long executionTime = System.currentTimeMillis() - start;

		// finally printing the time
		System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		return proceed;
	}
}
