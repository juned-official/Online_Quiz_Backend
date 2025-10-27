package com.juned;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data

	public class ErrorResponse {
		
	public ErrorResponse(String string, HttpStatus status) {
			this.Message=string;
			this.Status=status;
			this.Timestamp = LocalDateTime.now();
		}
	private String Message;
	private HttpStatus Status;
	private LocalDateTime Timestamp;
	}

