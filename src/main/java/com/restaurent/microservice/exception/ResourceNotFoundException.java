package com.restaurent.microservice.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String message, String string)
	{
		super(message);
	}

}
