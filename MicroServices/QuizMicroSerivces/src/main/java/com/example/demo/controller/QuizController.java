package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.QuizService;
import com.example.demo.model.QuestionWrapper;
import com.example.demo.model.QuizDto;
import com.example.demo.model.Response;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	Environment environmant;
	
	@PostMapping("/create")
	//http://localhost:8080/quiz/create?category=Science&numQ=5&title=JQuiz
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
		return quizService.createQuiz(quizDto.getCategory(),quizDto.getNumQ(),quizDto.getTitle());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(@PathVariable  int id){
		System.out.println(environmant.getProperty("local.server.port"));
		return quizService.getQuizQuestionsById(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses){
		return quizService.calculateResult(id,responses);
	}
}
