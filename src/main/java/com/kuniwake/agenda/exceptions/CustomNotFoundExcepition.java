package com.kuniwake.agenda.exceptions;

public class CustomNotFoundExcepition extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CustomNotFoundExcepition(String message, Throwable cause) {
		super(message, cause);
		
	}

	public CustomNotFoundExcepition(String message) {
		super(message);
		
	}
	
}
