package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Repo.QuestionRepo;
import com.example.demo.model.QuestionDB;
import com.example.demo.model.QuestionWrapper;
import com.example.demo.model.Response;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    // Get all questions
    public ResponseEntity<List<QuestionDB>> getAllquestions() {
        try {
            List<QuestionDB> questions = questionRepo.findAll();
            if (questions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 if no content found
            }
            return new ResponseEntity<>(questions, HttpStatus.OK); // 200 if questions found
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 for server error
        }
    }

    // Get questions by category
    public List<QuestionDB> findByCategory(String category) {
        return questionRepo.findByCategory(category);
    }

    // Add a new question
    public void addQuestion(QuestionDB question) {
        questionRepo.save(question);
    }

    // Update an existing question
    public void updateQuestion(QuestionDB questionDB) {
        questionRepo.save(questionDB);
    }

    // Delete a question by ID
    public boolean deleteQuestion(int id) {
        if (questionRepo.existsById(id)) {
            questionRepo.deleteById(id);
            return true; // return true if delete is successful
        }
        return false; // return false if the question does not exist
    }

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, int numQuestions) {
		
List<Integer> questions = questionRepo.findRandomQuestionsByCategory(categoryName,numQuestions);
		
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsfronId(List<Integer> questionIds) {
		
		List<QuestionWrapper> wrappers = new ArrayList<>();
		List<QuestionDB> questions = new ArrayList<>();
		
		for(Integer id : questionIds) {
			questions.add(questionRepo.findById(id).get());
		}
		
		for(QuestionDB question :  questions) {
			
			QuestionWrapper wrapper = new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());
			wrappers.add(wrapper);
		}
		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {

		int right = 0;
		for(Response response : responses) {
			
			QuestionDB questions = questionRepo.findById(response.getId()).get();
			if(response.getResponse().equals(questions.getRightAnswer())) {
				right++;
			}
	
		}
		
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
}
