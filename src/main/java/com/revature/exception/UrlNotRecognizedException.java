
package com.revature.exception;

public class UrlNotRecognizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * UrlNotRecognizedException:
	 * 1. Receives exception message.
	 * 2. Passes exception message to super.
	 * @param message
	 */
	public UrlNotRecognizedException(String message) { 
		super(message); 
		message = "PLEASE ENTER VALID URL";
	} 
}
		