package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.demo.Model.JobPost;


@RepositoryRestResource(collectionResourceRel = "jobPosts", path = "jobPosts")
public interface JobPostRepo extends JpaRepository<JobPost, Integer>{

}
