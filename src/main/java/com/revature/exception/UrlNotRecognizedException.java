
package com.revature.exception;

public class UrlNotRecognizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UrlNotRecognizedException(String message) { 
		super(message); 
	} 
}
		