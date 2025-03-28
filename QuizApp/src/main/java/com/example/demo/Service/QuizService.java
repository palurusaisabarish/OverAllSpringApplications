package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.QuestionRepo;
import com.example.demo.Repo.QuizRepo;
import com.example.demo.model.QuestionDB;
import com.example.demo.model.QuestionWrapper;
import com.example.demo.model.Quiz;
import com.example.demo.model.Response;

@Service
public class QuizService {

	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionRepo questionRepo;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<QuestionDB> questions = questionRepo.findRandomQuestionsByCategory(category,numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionDB(questions);
		quizRepo.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(int id) {
		
		Optional<Quiz> quiz = quizRepo.findById(id);
		List<QuestionDB> questionsfromDB = quiz.get().getQuestionDB();
		List<QuestionWrapper> questionsforUser = new ArrayList<>();
		
		for(QuestionDB q : questionsfromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsforUser.add(qw);
		}
		
		return new ResponseEntity<>(questionsforUser , HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
	
		Quiz quiz = quizRepo.findById(id).get();
		List<QuestionDB> questions = quiz.getQuestionDB();
		
		int i = 0;
		int right = 0;
		
		for(Response response : responses) {
			
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
			
			i++;
			
		}
		return new ResponseEntity<>(right , HttpStatus.OK);
	}
	
	
}
