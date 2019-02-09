package com.clebercmb.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException { //It´s been using RuntimeException because 
																//an auxiliary class will be used to handle the exception.
																//So it won´t be necessary to handle the exception at the point
																//that the method calls this exception

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super (msg);
	}
}
