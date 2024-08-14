package com.linxin.SpringBootRest;

import com.linxin.SpringBootRest.model.JobPost;
import com.linxin.SpringBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping(path = "jobPosts", produces = {"application/json"}) // this method only returns json data, not xml
    // @ResponseBody // what it sent is an actual data body, not the view name
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) { // check url path and get variable postId
        return service.getJob(postId);
    }

    @PostMapping(path = "jobPost", consumes = {"application/xml"}) // this method only accept xml data, not json
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId) {
        service.deleteJob(postId);
        return "deleted";
    }

    @GetMapping("load")
    public String loadData() {
        service.load();
        return "loaded successfully";
    }

}
