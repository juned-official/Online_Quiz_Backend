package com.juned.Controller;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.juned.Entity.Quiz;
import com.juned.Exceptions.UserNotFoundException;

import com.juned.Repository.QuizRepo;
import com.juned.Responses.CheckQuizStart;


@RestController

@RequestMapping("api/take")
public class ControlStd {

	@Autowired
	private QuizRepo qRepo;
	@GetMapping("/MyQuestions/{quizID}")
	public ResponseEntity<Quiz> MyAllQuestions(@PathVariable Long quizID){
		
		Optional<Quiz> quiz=qRepo.findById(quizID);
		
		return ResponseEntity.ok(quiz.orElseThrow(()->new UserNotFoundException("Invalid Code")));
	}
	@GetMapping("check/{quizId}")
	public ResponseEntity<CheckQuizStart> CheckQuizStarted(@PathVariable Long quizId){
		Optional<Quiz> qu=qRepo.findById(quizId);
		CheckQuizStart obj=new CheckQuizStart();
		if(qu.isPresent() && !qu.isEmpty()) {
			if(!qu.get().getIsStarted()) {
			obj.setMessg("Quiz has not been started by the Host");
			obj.setStarted(false);}
			else {
				obj.setMessg("Quiz is started");
				obj.setStarted(true);
			}
		}
		else {
			obj.setMessg("Code is Invalid, Try Again");
		}
		return ResponseEntity.ok(obj);
	}
}
