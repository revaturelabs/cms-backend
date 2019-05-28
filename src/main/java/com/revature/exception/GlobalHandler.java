
package com.revature.exception;

import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;
import static com.revature.util.ClientMessageUtil.URL_NOT_RECOGNIZED;
import static com.revature.util.ClientMessageUtil.CONTENT_NOT_FOUND;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.revature.util.ClientMessage;
//import com.revature.util.ClientMessageUtil;

@ControllerAdvice
public class GlobalHandler {
	private static Logger logger = Logger.getLogger(GlobalHandler.class);

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ClientMessage> handleAnyException(Throwable t) {
		logger.error("Internal Error", t);
		return new ResponseEntity<>(SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UrlNotRecognizedException.class)
	public ResponseEntity<ClientMessage> handleUrlNotRecognizedException(UrlNotRecognizedException e) {
		logger.error("Invalid url data detected", e);
		return new ResponseEntity<>(URL_NOT_RECOGNIZED, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
	
	@ExceptionHandler(ContentNotFoundException.class)
	public ResponseEntity<ClientMessage> handleContentNotFoundException(ContentNotFoundException e) {
		logger.error("Content not found", e);
		return new ResponseEntity<>(CONTENT_NOT_FOUND, HttpStatus.BAD_REQUEST);
	}
}
