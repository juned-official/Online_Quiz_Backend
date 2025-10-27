package com.juned.Responses;

import java.util.List;

import com.juned.Entity.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespAllQuestions {

	private List<Question> AllQues=null;
	private Boolean IsAvailable=false;
}
