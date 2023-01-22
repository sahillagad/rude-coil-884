package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandlerClass {

//	Exception Handler for Exception class
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionClassHandler(Exception exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),exception.getMessage(),request.getDescription(false));
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}
	
	

//	Data validation exception handler
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> exceptionClassHandler(MethodArgumentNotValidException exception){
		
		
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),exception.getMessage());
		details.setDetails(exception.getBindingResult().getFieldError().getDefaultMessage());
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}
	
	
	
//	Exception Handler for No URI found or wrong uri
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> exceptionClassHandler(NoHandlerFoundException exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),exception.getMessage(),request.getDescription(false));
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}
	
	
//	Exception handler for CallException  Exception
	@ExceptionHandler(CallException.class)
	public ResponseEntity<ErrorDetails> CallExceptionClassHandler(CallException exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),exception.getMessage(),request.getDescription(false));
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}
	
//	Exception handler for CustomerException  Exception	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> CustomerExceptionClassHandler(CustomerException exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),exception.getMessage(),request.getDescription(false));
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}
	
//	Exception handler for OperatorException  Exception	
	@ExceptionHandler(OperatorException.class)
	public ResponseEntity<ErrorDetails> OperatorExceptionClassHandler(OperatorException exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),exception.getMessage(),request.getDescription(false));
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}
	
	
//	Exception handler for ProblemException  Exception	
	@ExceptionHandler(ProblemException.class)
	public ResponseEntity<ErrorDetails> ProblemExceptionClassHandler(ProblemException exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),exception.getMessage(),request.getDescription(false));
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}
	
	
	
//	Exception handler for SolutionException
	@ExceptionHandler(SolutionException.class)
	public ResponseEntity<ErrorDetails> SolutionExceptionClassHandler(SolutionException exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),exception.getMessage(),request.getDescription(false));
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}
	
}
