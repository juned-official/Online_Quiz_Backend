package com.juned.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.juned.Entity.Quiz;
import com.juned.Entity.User_entity;
@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {

	// <returnType> findBy/readBy/existsBy/countBy/deleteBy + <currentFieldName>_<otherclassfieldName>'
	Optional<List<Quiz>> findByUser_UserId(Long id);
	
}
