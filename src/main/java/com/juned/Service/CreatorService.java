package com.juned.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.juned.DTO.EmailRequest;
import com.juned.Entity.Quiz;
import com.juned.Entity.User_entity;
import com.juned.Repository.QuizRepo;
import com.juned.Repository.UserRepo;
import com.juned.Responses.CheckQuizStart;

@Service
public class CreatorService {
@Autowired
private QuizRepo quizrepo;
@Value("${MAIL_USERNAME}")
private String senderMail;
@Autowired
JavaMailSender javaMailSender;
@Autowired
private UserRepo userRepo;
	public Optional<Quiz> findById(Long code) {
		
		return quizrepo.findById(code);
	}
	public ResponseEntity<Long> AddQuiz(Quiz myquiz) {
		
		Optional<User_entity> user=userRepo.findById(myquiz.getUserId());
		if(user.isPresent()) {
		myquiz.setUser(user.get());
		
		}
		else
			return ResponseEntity.ok(-1l);
			Quiz q=quizrepo.save(myquiz);
			
		
		
			return ResponseEntity.ok(q.getQuizId());
	}
	public Optional<List<Quiz>> FindAllQuiz(Long id) {
		
		return quizrepo.findByUser_UserId(id);
	}
	public String DeleteQuiz(Long quizID) {
		quizrepo.deleteById(quizID);
		return "Quiz Deleted successfully";
	}
	public ResponseEntity<CheckQuizStart> ToggleQuiz(Long quizId) {
		Optional<Quiz> quiz=quizrepo.findById(quizId);
		CheckQuizStart obj=new CheckQuizStart();
		if(quiz.isPresent()) {
			if(quiz.get().getIsStarted()) {
				quiz.get().setIsStarted(false);
				quizrepo.save(quiz.get());
				obj.setStarted(false);
				obj.setMessg("Quiz stopped successfully");
			}
			else {
				obj.setStarted(true);
				
				quiz.get().setIsStarted(true);
				quizrepo.save(quiz.get());
				obj.setMessg("Quiz started successfully");
				
			}
		}
		return ResponseEntity.ok(obj) ;
	
	}
	public ResponseEntity<CheckQuizStart> SendSmsToX(EmailRequest emailRequest) {
		CheckQuizStart obj=new CheckQuizStart();
		if(emailRequest.getPurpose().equals("register")){
			
		if(userRepo.existsByEmail(emailRequest.getRecipient())) {
			obj.setMessg("Account already exist");
			return ResponseEntity.ok(obj);
		}
		else {
			return sendEmail(emailRequest);	
		}
		}
		else if(emailRequest.getPurpose().equals("passwordReset")) {
			if(userRepo.existsByEmail(emailRequest.getRecipient())) {
				return sendEmail(emailRequest);	
			}
			else {
				obj.setMessg("Email Id not found");
				
				return ResponseEntity.ok(obj);
			}
		}
		return null;
	}
	public ResponseEntity<CheckQuizStart>  sendEmail(EmailRequest emailRequest) {
		try{
			SimpleMailMessage sms =new SimpleMailMessage();
			sms.setTo(emailRequest.getRecipient());
			sms.setText(emailRequest.getBody());
			sms.setSubject(emailRequest.getSubject());
			
			sms.setFrom(senderMail);
			
			
			javaMailSender.send(sms);
			return ResponseEntity.status(200).body(new CheckQuizStart("OTP sent Successfully",true));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(new CheckQuizStart("kuch to gadbad hai! because "+e.getLocalizedMessage(),false));
		}
	}
	
	

}
