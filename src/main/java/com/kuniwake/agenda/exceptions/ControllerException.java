package com.kuniwake.agenda.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Classe para Manipular as Exceptions
@ControllerAdvice
public class ControllerException {

	// Exception para valores não encontrados
	@ExceptionHandler(CustomNotFoundExcepition.class)
	public ResponseEntity<StandardError> customNotFoundExcepition(CustomNotFoundExcepition c, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				c.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	// Exception de integridade do BD
	@ExceptionHandler(CustomDataIntegrityViolationExcepition.class)
	public ResponseEntity<StandardError> customDataIntegrityViolationExcepition(
			CustomDataIntegrityViolationExcepition c, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				c.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	// Exception de validação de campos
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> customValidateErros(
			MethodArgumentNotValidException e, ServletRequest request) {
		ValidatioError error = new ValidatioError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Erro na validação dos campos");
		for(FieldError f : e.getBindingResult().getFieldErrors()) {
			error.addErrors(f.getField(), f.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
