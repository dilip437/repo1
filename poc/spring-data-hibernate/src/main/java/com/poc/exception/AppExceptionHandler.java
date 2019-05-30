package com.poc.exception;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.poc.model.ErrorResponse;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleAuthorizationException(AccessDeniedException e) {	
		return new ErrorResponse(e.toString());
    }
		
	@ExceptionHandler(EntitySaveException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleEntitySaveException(EntitySaveException e) {
		return new ErrorResponse(e.toString());
    }
	
	@ExceptionHandler(EntityUpdateException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleEntityUpdateException(EntityUpdateException e) {
		return new ErrorResponse(e.toString());
    }
	
	@ExceptionHandler(EntityRemoveException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleEntityRemoveException(EntityRemoveException e) {
		return new ErrorResponse(e.toString());
    }
	
	@ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleEntityNotFoundException(EntityNotFoundException e) {
		return new ErrorResponse(e.toString());
    }
}
