package com.juned.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juned.Entity.Question;
@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
		Optional<List<Question>> findAllByQuiz_quizId(Long Id);
}
