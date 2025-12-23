package com.felipeoliveira.mongodbproject.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.felipeoliveira.mongodbproject.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	public ResponseEntity <StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		// usa o horário atual do sistema System.currentTimeMillis(), status.value() converte para inteiro
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(),"Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
