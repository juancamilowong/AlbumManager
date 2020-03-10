package com.albummanager.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.albummanager.exception.ErrorResponse;

@ControllerAdvice
public class ArgumentErrorHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> methodArgumentNotValidException(HttpServletRequest request,
			MethodArgumentNotValidException e) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"Bad argument in " + request.getRequestURI());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ErrorResponse> numberFormatException(HttpServletRequest request,
			NumberFormatException e) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"Bad argument for number in " + request.getRequestURI());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
