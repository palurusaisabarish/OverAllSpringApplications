package com.example.demo.Repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.example.demo.JobPost;

@Repository
public class JobRepo  {
	
	List<JobPost> jobs = new ArrayList<>(Arrays.asList(
	new JobPost(91906, "Java Developer", 
            "We are looking for a skilled Java Developer with experience in Spring Boot and Hibernate.", 
            5, Arrays.asList("Java", "Spring Boot", "Hibernate")),
	new JobPost(91907, "Frontend Developer", 
            "Join our team as a Frontend Developer with a strong background in React and JavaScript.", 
            3, Arrays.asList("JavaScript", "React", "HTML", "CSS")),
	new JobPost(91908, "Backend Developer", 
            "Seeking an experienced Backend Developer with expertise in Node.js and MongoDB.", 
            4, Arrays.asList("Node.js", "MongoDB", "Express")),
	new JobPost(91909, "Full Stack Developer", 
            "Looking for a Full Stack Developer skilled in both frontend and backend technologies.", 
            6, Arrays.asList("Java", "Angular", "Spring Boot", "MySQL")),
	new JobPost(91910, "DevOps Engineer", 
            "We are hiring a DevOps Engineer with experience in Kubernetes and Docker.", 
            4, Arrays.asList("Kubernetes", "Docker", "Jenkins")),
	new JobPost(91911, "Data Scientist", 
            "Join us as a Data Scientist to work on machine learning and AI algorithms.", 
            5, Arrays.asList("Python", "R", "Machine Learning", "TensorFlow")),
	new JobPost(91912, "QA Engineer", 
            "Looking for a QA Engineer with expertise in automated testing frameworks.", 
            3, Arrays.asList("Python","java"))
));

	

	public List<JobPost> getAlljobs(){
		return jobs;
	}

	public void addjobs(JobPost job) {
		jobs.add(job);
		System.out.println(jobs);
	}
	
	public JobPost getJob(int postId) {
		
		for(JobPost post:jobs) {
			
			if(post.getPostId() == postId) {
				return post;
			}
		}
		
		return null;
	}

	public JobPost updateJob(JobPost jobpost) {
		
		for(JobPost job : jobs) {
			
			if(job.getPostId() == jobpost.getPostId()) {
				job.setPostProfile(jobpost.getPostProfile());
				job.setPostDesc(jobpost.getPostDesc());
				job.setReqExperience(jobpost.getReqExperience());
				job.setPostTechStack(jobpost.getPostTechStack());
			}
		}
		return null;
	}

	public void deleteJob(int postId) {
		jobs.removeIf(jobpost -> jobpost.getPostId() == postId);
	}
}



