package com.example.demo.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Repo.QuestionRepo;
import com.example.demo.model.QuestionDB;

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
}
