package com.linxin.SpringBootRest;

import com.linxin.SpringBootRest.model.JobPost;
import com.linxin.SpringBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // @Controller + @ResponseBody
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    // @ResponseBody // what it sent is an actual data body, not the view name
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

}
