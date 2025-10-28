package com.juned.Controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juned.Entity.Quiz;
import com.juned.Entity.User_entity;
import com.juned.Exceptions.UserNotFoundException;
import com.juned.Repository.UserRepo;
import com.juned.Responses.CheckQuizStart;
import com.juned.Service.CreatorService;

@RestController

@RequestMapping("/api/quizzes")
public class CreatorApiController {
	@Autowired
	private CreatorService quizservice;
	@Autowired
	private UserRepo userrepo;
	
@GetMapping("Get/{User_id}")
public ResponseEntity<User_entity> getAllQuizz(@PathVariable Long User_id){
	
	Optional<User_entity> myQuizzez=userrepo.findById(User_id);
	
	

	return ResponseEntity.ok(myQuizzez.orElseThrow(()-> new UserNotFoundException("Invalid UserId")));
		
	
}
@DeleteMapping("/delete/{quizID}")
public ResponseEntity<CheckQuizStart> deleteQuiz(@PathVariable Long quizID){
	
	return ResponseEntity.ok(new CheckQuizStart(quizservice.DeleteQuiz(quizID),true));
}
@PostMapping("/createQuiz")
public ResponseEntity<Long> createQuiz(@RequestBody Quiz Myquiz){
	
return   quizservice.AddQuiz(Myquiz);

	
}
@PutMapping("/toggleQuiz")
public ResponseEntity<CheckQuizStart> ToggleQuiz(@RequestBody Long quizId){
	return quizservice.ToggleQuiz(quizId);
	
}

	
}
