package com.example.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component  //questionDB
@Entity
@Table(name = "questiondb")
public class QuestionDB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String category; 
	private String difficultyLevel; 
	private String option1;
	private String option2; 
	private String option3;
	private String option4;
	private String questionTitle; 
	private String rightAnswer;
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", category=" + category + ", difficultyLevel=" + difficultyLevel + ", option1="
				+ option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
				+ ", question_title=" + questionTitle + ", right_answer=" + rightAnswer + "]";
	}

	public QuestionDB() {	}
	
	public QuestionDB(int id, String category, String difficultyLevel, String option1, String option2, String option3,
			String option4, String questionTitle, String rightAnswer) {
		this.id = id;
		this.category = category;
		this.difficultyLevel = difficultyLevel;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.questionTitle = questionTitle;
		this.rightAnswer = rightAnswer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	
	
}
