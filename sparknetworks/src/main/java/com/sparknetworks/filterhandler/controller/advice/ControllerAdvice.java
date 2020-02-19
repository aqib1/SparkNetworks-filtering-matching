package com.sparknetworks.filterhandler.controller.advice;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.sparknetworks.filterhandler.exceptions.DataNotFoundException;
import com.sparknetworks.filterhandler.exceptions.InvalidRequestException;
import com.sparknetworks.model.ResponseError;

@RestControllerAdvice
public class ControllerAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

	/**
	 * @param e
	 * @param wr
	 * @return
	 */
	@ExceptionHandler(value = { InvalidRequestException.class })
	public ResponseEntity<ResponseError> handleInvalidRequestException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ " [Invalid request exception! => (InvalidRequestException)]";
		ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
				.detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
				.exceptionName(InvalidRequestException.class.getName()).errorMessage(e.getMessage());
		logger.error(errorResponse.toString(), e);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	

	/**
	 * @param e
	 * @param wr
	 * @return
	 */
	@ExceptionHandler(value = { DataNotFoundException.class })
	public ResponseEntity<ResponseError> handleDataNotFoundException(RuntimeException e, WebRequest wr) {
		String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
				+ " [Data not found exception! => (DataNotFoundException)]";
		ResponseError errorResponse = new ResponseError().createdAt(LocalDateTime.now().toString())
				.detailedMessage(error).errorCode(HttpStatus.EXPECTATION_FAILED.value())
				.exceptionName(DataNotFoundException.class.getName()).errorMessage(e.getMessage());
		logger.error(errorResponse.toString(), e);
		return new ResponseEntity<>(errorResponse, HttpStatus.EXPECTATION_FAILED);
	}
}
