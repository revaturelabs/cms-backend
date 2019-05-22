package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {
	private static final Logger logger = Logger.getLogger(TracingAspect.class);
	
	@After("execution(* new* (..))")
	public void creating(JoinPoint jp) {
		logger.trace("Attempting creation: " + jp.getStaticPart().getSignature().toString() 
				+ " with parameter: " + jp.getArgs()[0]);
	}
	
	@After("execution(* find* (..))")
	public void finding(JoinPoint jp) {
		logger.trace("Attempting findBy: " + jp.getStaticPart().getSignature().toString() 
				+ " with parameter: " + jp.getArgs()[0]);
	}
	
	@After("execution(* delete* (..))")
	public void deleting(JoinPoint jp) {
		logger.trace("Attempting delete: " + jp.getStaticPart().getSignature().toString() 
				+ " with parameter: " + jp.getArgs()[0]);
	}
	
	@After("execution(* update* (..))")
	public void update(JoinPoint jp) {
		logger.trace("Attempting update: " + jp.getStaticPart().getSignature().toString() 
				+ " with parameter: " + jp.getArgs()[0]);
	}
	

}
