/**
 * 
 */
package com.aurino.cursoau.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aurino.cursoau.service.exceptions.BusinessException;
import com.aurino.cursoau.service.exceptions.ObjectNotFoundException;

/**
 * Classe responsável por capturar as exceções da aplicação e lança-las no retorno do serviço.
 *
 * @author marcelo.aurino
 *
 */
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErrorPadrao> objectNotFoundException(
			ObjectNotFoundException onfe, HttpServletRequest request){
		
		ErrorPadrao err = new ErrorPadrao(HttpStatus.NOT_FOUND.value(), onfe.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorPadrao> businessException(
			BusinessException onfe, HttpServletRequest request){
		
		ErrorPadrao err = new ErrorPadrao(HttpStatus.NOT_FOUND.value(), onfe.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
