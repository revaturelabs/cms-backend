
package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.revature.exception.ContentNotFoundException;
import com.revature.exception.UrlNotRecognizedException;

@Component

@Aspect
public class ExceptionAspect {
	private static final Logger logger = Logger.getLogger(ExceptionAspect.class);

	@AfterThrowing(pointcut = "execution(* findByURL(..))", throwing = "e")
	public void exceptionHandling(JoinPoint jp, UrlNotRecognizedException e) {
		logger.error("Exception thrown in: " + jp.getStaticPart().getSignature().toString());
	}
	
	@AfterThrowing(pointcut = "execution(* findBy*(..))", throwing = "e")
	public void exceptionHandling(JoinPoint jp, ContentNotFoundException e) {
		logger.error("Exception thrown in: " + jp.getStaticPart().getSignature().toString());
	}
}
