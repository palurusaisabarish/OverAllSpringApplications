package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.QuestionService;
import com.example.demo.model.QuestionDB;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Get all questions
    @GetMapping("/allquestions")
    public ResponseEntity<List<QuestionDB>> getAllQuestions() {
        System.out.println("getAllQuestions Called...");
        return questionService.getAllquestions();
    }

    // Get questions by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<QuestionDB>> getQuestionByCategory(@PathVariable String category) {
        System.out.println("getQuestionByCategory Called...");
        List<QuestionDB> questions = questionService.findByCategory(category);
        if (questions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 if no questions found
        }
        return new ResponseEntity<>(questions, HttpStatus.OK); // 200 if questions found
    }

    // Add a new question
    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionDB question) {
        System.out.println("addQuestion Called...");
        questionService.addQuestion(question);
        return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED); // 201 for creation
    }

    // Update an existing question
    @PutMapping("/updateQuestion")
    public ResponseEntity<String> updateQuestion(@RequestBody QuestionDB questionDB) {
        System.out.println("updateQuestion Called...");
        questionService.updateQuestion(questionDB);
        return new ResponseEntity<>("Question updated successfully", HttpStatus.OK); // 200 for successful update
    }

    // Delete a question by ID
    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        System.out.println("deleteQuestion Called...");
        boolean isDeleted = questionService.deleteQuestion(id);
        if (isDeleted) {
            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK); // 200 for successful deletion
        } else {
            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND); // 404 if question doesn't exist
        }
    }
    
    
}
