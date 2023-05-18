package com.ssafy.trip.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionRestController {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> error(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Exception : "+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR); // 500
	}
}
