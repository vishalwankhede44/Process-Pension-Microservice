package com.cognizant.ProcessPension.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.ProcessPension.controller.ProcessPensionController;



@ControllerAdvice
@RestController
@SuppressWarnings("PMD.GuardLogStatementJavaUtil")
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);
	
	@ExceptionHandler(PensionerNotFoundException.class)
    public final ResponseEntity<Object> handlePensionerNotFoundException(Exception ex,WebRequest webRequest){
		
		LOGGER.info("CustomizedResponseEntityExceptionHandler - handlePensionerNotFoundException - Started ");
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(),ex.getMessage());
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("CustomizedResponseEntityExceptionHandler - handlePensionerNotFoundException - Ended -> Message -> {} ",ex.getMessage());
		return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND); 
		
	}
	
	@ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> handleBadRequestException(Exception ex,WebRequest webRequest){
		LOGGER.info("CustomizedResponseEntityExceptionHandler - handleBadRequestException - Started ");
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(),ex.getMessage());
		LOGGER.info("CustomizedResponseEntityExceptionHandler - handleBadRequestException - Ended ");
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST); 
		
	}

	@ExceptionHandler(CustomException.class)
    public final ResponseEntity<Object> handleInvalidTokenException(Exception ex,WebRequest webRequest)
	{
		LOGGER.info("CustomizedResponseEntityExceptionHandler - handleInvalidTokenException - Started ");
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(),ex.getMessage());
		LOGGER.info("CustomizedResponseEntityExceptionHandler - handleInvalidTokenException - Ended ");
		return new ResponseEntity<>(exceptionResponse,HttpStatus.FORBIDDEN); 
		
	}
	
}
