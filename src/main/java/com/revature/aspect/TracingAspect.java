package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {
	private static final Logger logger = Logger.getLogger(TracingAspect.class);
	
	@After("execution(* createContent (..))")
	public void creating(JoinPoint jp) {
		logger.info("Attempting creation: " + jp.getStaticPart().getSignature().toString() 
				+ " with parameter: " + jp.getArgs());
	}
	
	@After("execution(* findByURL (..))")
	public void finding(JoinPoint jp) {
		logger.info("dummy string");//"Attempting findBy: " + jp.getStaticPart().getSignature().toString() 
				//+ " with parameter: " + jp.getArgs());
	}
	
	@After("execution(* deleteContent ())")
	public void deleting(JoinPoint jp) {
		logger.trace("Attempting delete: " + jp.getStaticPart().getSignature().toString() 
				+ " with parameter: " + jp.getArgs());
	}
	
	@After("execution(* updateContent (..))")
	public void update(JoinPoint jp) {
		logger.trace("Attempting update: " + jp.getStaticPart().getSignature().toString() 
				+ " with parameter: " + jp.getArgs());
	}
	

}
