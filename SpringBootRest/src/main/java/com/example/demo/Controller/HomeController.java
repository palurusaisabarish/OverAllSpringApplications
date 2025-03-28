package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JobPost;
import com.example.demo.Service.JobSerivce;

@RestController
public class HomeController {

	@Autowired
	private JobSerivce jobserivce;
	
	
	@GetMapping("jobposts")
	public List<JobPost> getalljobs(){
		return jobserivce.getAllJobs();
	}
	
	//@GetMapping("jobpost/3")
	@GetMapping("jobpost/{postId}")
	public JobPost getJob(@PathVariable("postId") int postId) {
	    System.out.println("Fetching job with postId: " + postId);  // Log the postId
	    JobPost jobPost = jobserivce.getJob(postId);
	    if (jobPost != null) {
	        System.out.println("Job found: " + jobPost.getPostProfile());
	    } else {
	        System.out.println("Job not found with postId: " + postId);
	    }
	    return jobPost;
	}
	
	@PostMapping("jobpost")
	public JobPost addJob(@RequestBody JobPost jobpost) {
		jobserivce.addJob(jobpost);
		return jobserivce.getJob(jobpost.getPostId());
	}
	
	@PutMapping("jobpost")
	public JobPost updateJob(@RequestBody JobPost jobpost) {
		return jobserivce.updateJob(jobpost);
		
	}
	
	@DeleteMapping("jobpost/{postId}")
	public String deleteJob(@PathVariable int postId) {
			jobserivce.deleteJob(postId);
			return "deleted";
	}

}
