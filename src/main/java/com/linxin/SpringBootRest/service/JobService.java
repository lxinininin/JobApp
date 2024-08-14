package com.linxin.SpringBootRest.service;

import com.linxin.SpringBootRest.model.JobPost;
import com.linxin.SpringBootRest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }

    public JobPost getJob(int postId) {
        return repo.getJob(postId);
    }
}
