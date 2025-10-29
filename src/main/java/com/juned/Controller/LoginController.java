package com.juned.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juned.Entity.User_entity;
import com.juned.Repository.UserRepo;
import com.juned.Responses.AIO;
import com.juned.Responses.CheckQuizStart;

@RestController
@CrossOrigin(origins="https://juned-official.github.io")
@RequestMapping("/User")
public class LoginController {
	@Autowired
	private UserRepo userRepo;
	
@PostMapping("/check")
public ResponseEntity<AIO> checkCredentail(@RequestBody User_entity user){
	Optional<User_entity> user2=userRepo.findByEmail(user.getEmail());
	AIO obj=new AIO();
	
	if(!user2.isPresent() && user2.isEmpty()) {
		obj.setMsg("Email not found");
		obj.setFlag(false);
		obj.setNum(-1l);
		
		
	}
	else if(!user2.get().getPassword().equals(user.getPassword())){
		obj.setMsg("Password is Incorrect");
		obj.setFlag(false);
		obj.setNum(-1l);
	}
	else {
		obj.setFlag(true);
		obj.setNum(user2.get().getUserId());
		obj.setMsg("Login successfull");
	}
	System.out.println(obj.getMsg()+"\t"+obj.getNum()+"\t"+obj.isFlag());
	return ResponseEntity.status(200).body(obj);
		
}
@PostMapping("/AddUser")
public ResponseEntity<User_entity> AddUser(@RequestBody User_entity user){
	User_entity main=userRepo.save(user);
	return   ResponseEntity.ok(main);
}
@DeleteMapping("/DeleteUser/{userId}")
public ResponseEntity<CheckQuizStart> deleteUser(@PathVariable Long userId){
	userRepo.deleteById(userId);
	return ResponseEntity.ok(new CheckQuizStart("Account Deletion process completed",true));
}
	
}
