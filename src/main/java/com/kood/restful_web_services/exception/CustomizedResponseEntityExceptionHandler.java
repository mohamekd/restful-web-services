package com.kood.restful_web_services.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.kood.restful_web_services.controllers.UserNotFoundError;

@ControllerAdvice 
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private ErrorDetails defineErrorDetails(Exception ex, WebRequest request) {
		return	 new ErrorDetails(LocalDateTime.now(),
				ex.getMessage(),request.getDescription(false));
	}
	
	//any error handling
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		return new ResponseEntity<ErrorDetails>(defineErrorDetails(ex, request),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//user not found error handling
	@ExceptionHandler(UserNotFoundError.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		return new ResponseEntity<ErrorDetails>(defineErrorDetails(ex, request),HttpStatus.NOT_FOUND);
	}
	
	//validation error handling
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		return new ResponseEntity<Object>(new ErrorDetails(
				LocalDateTime.now(),
				"Total Errors : "+ex.getErrorCount()+" , First Error : "+ex.getFieldError().getDefaultMessage(),
				request.getDescription(false))
				,HttpStatus.BAD_REQUEST);
	}


	
	
	
}
