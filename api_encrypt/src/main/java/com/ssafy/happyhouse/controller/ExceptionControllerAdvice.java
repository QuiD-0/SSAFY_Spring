package com.ssafy.happyhouse.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.security.auth.message.AuthException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	private Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> handleException(Exception ex) {
		logger.error("Exception 발생 : {}", ex.getMessage());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Void> handle404(NoHandlerFoundException ex) {
		logger.error("404 발생 : {}", "404 page not found");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(AuthException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	public ResponseEntity<String> handleNoAuth(AuthException ex) {
		logger.error("인증 오류 발생 : {}", "Unauthrized");
		JSONObject json = new JSONObject();
		json.put("message", "Unauthrized");
		return new ResponseEntity<>(json.toString(), HttpStatus.UNAUTHORIZED);

	}
	
}

