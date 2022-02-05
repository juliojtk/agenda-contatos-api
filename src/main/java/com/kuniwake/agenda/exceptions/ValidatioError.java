package com.kuniwake.agenda.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidatioError extends StandardError{
	
	private List<CustomFieldErrorMsg> errors = new ArrayList<>();

	public ValidatioError() {
		super();
	}

	public ValidatioError(Long time, Integer status, String msg) {
		super(time, status, msg);
	}
	
	public List<CustomFieldErrorMsg> getErrors() {
		return errors;
	}

	// Adicionando os erros e uma lista de erros
	public void addErrors(String fildName, String msg) {
		this.errors.add(new CustomFieldErrorMsg(fildName, msg));
	}
	
	

}
