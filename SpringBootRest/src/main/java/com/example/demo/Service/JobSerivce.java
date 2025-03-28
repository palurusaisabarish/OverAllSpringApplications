package com.example.demo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JobPost;
import com.example.demo.Repo.JobRepo;

@Service
public class JobSerivce {


	@Autowired
	private JobRepo repo;
	
	public void addJob(JobPost jobs){
		repo.addjobs(jobs);
	}
	
	public List<JobPost> getAllJobs(){
		return repo.getAlljobs();
	}
	
	public JobPost getJob(int postId) {
		return repo.getJob(postId);
	}

	public JobPost updateJob(JobPost jobpost) {
		return repo.updateJob(jobpost);
	}

	public void deleteJob(int postId) {
		repo.deleteJob(postId);
		
	}
}
