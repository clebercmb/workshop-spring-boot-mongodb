package com.clebercmb.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.clebercmb.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice  //It indicates that this class is responsible to handle possible errors on requests 
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class) //It indicates to the framework what to do when this exception happens
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
	
		HttpStatus status = HttpStatus.NOT_FOUND; //Error 404
		var err = new StandardError(System.currentTimeMillis(), status.value(), "Not found", e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(err);
		
		
	}

}
