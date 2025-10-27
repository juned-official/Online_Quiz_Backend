package com.juned;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.juned.Exceptions.UserNotFoundException;

import org.springframework.mail.MailSendException;

@ControllerAdvice
public class GlobalHandler {
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> IllegalArgument(Exception ex) {
        ErrorResponse error = new ErrorResponse(
            "Global Error handler says: Argument is invalid!"+
            ex.getMessage(),
            HttpStatus.NOT_ACCEPTABLE
        );
        return ResponseEntity.ok(error);
    }
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> UserException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
            "Global Error handler says: User Not Found"+
            ex.getMessage(),
            HttpStatus.NOT_FOUND
        );
        return ResponseEntity.ok(error);
    }
	 @ExceptionHandler(MailSendException.class)
	    public ResponseEntity<ErrorResponse> MailException(Exception ex) {
	        ErrorResponse error = new ErrorResponse(
	            "Global Error handler says: Incorrrect Gmail Id"+
	            ex.getMessage(),
	            HttpStatus.NOT_ACCEPTABLE
	        );
	        return ResponseEntity.ok(error);
	    }
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
	        ErrorResponse error = new ErrorResponse(
	            "Global Error handler says: Internal Server Error "+
	            ex.getMessage(),
	            HttpStatus.INTERNAL_SERVER_ERROR
	        );
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	    }
}
