package com.juned.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor 
public class EmailRequest {
	private String recipient="";
	private String subject="";
	private String body="";
	private String purpose="";
}
