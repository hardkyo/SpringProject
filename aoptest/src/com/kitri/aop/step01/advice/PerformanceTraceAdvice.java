package com.kitri.aop.step01.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {

	public Object trace(ProceedingJoinPoint joinpoint) throws Throwable {
		String signature = joinpoint.getSignature().toShortString();
		System.out.println(signature);
		
		long startTime = System.currentTimeMillis()	;
		try {
			Object result = joinpoint.proceed();
			return result;
		} finally {
			long endTime = System.currentTimeMillis();
			System.out.println("실행시간" + (endTime - startTime) + "ms");
		}

	}
	
}
