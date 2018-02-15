/**
 * 
 */
package com.aurino.cursoau.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
			BusinessException businessException, HttpServletRequest request){
		
		ErrorPadrao err = new ErrorPadrao(HttpStatus.CONFLICT.value(), businessException.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorPadrao> validation(
			MethodArgumentNotValidException manv, HttpServletRequest request){
		
		ValidacaoError err = new ValidacaoError(HttpStatus.CONFLICT.value(), "Erro de Validação de Campos", System.currentTimeMillis());
		for(final FieldError fieldError : manv.getBindingResult().getFieldErrors()) {
			err.adicionarErro(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
}
