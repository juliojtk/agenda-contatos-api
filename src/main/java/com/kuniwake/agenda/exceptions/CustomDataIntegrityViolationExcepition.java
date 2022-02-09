package com.kuniwake.agenda.exceptions;

public class CustomDataIntegrityViolationExcepition extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomDataIntegrityViolationExcepition(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomDataIntegrityViolationExcepition(String message) {
		super(message);
	}

}
