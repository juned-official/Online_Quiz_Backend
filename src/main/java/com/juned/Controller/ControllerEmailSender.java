package com.juned.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.juned.DTO.EmailRequest;
import com.juned.Responses.CheckQuizStart;
import com.juned.Service.CreatorService;

@RestController
@CrossOrigin(origins="https://juned-official.github.io")
public class ControllerEmailSender {
	

		@Value("${MAIL_USERNAME}")
		private String senderMail;
		@Autowired
		JavaMailSender javaMailSender;
		@Autowired
		CreatorService service;
		@PostMapping("/sendEmail")
		public ResponseEntity<CheckQuizStart> sendEmailTo(@RequestBody EmailRequest emailRequest) {
			System.out.println("sender email: "+senderMail);
			return service.SendSmsToX(emailRequest);
			
		
		}
		
		
		

	}
