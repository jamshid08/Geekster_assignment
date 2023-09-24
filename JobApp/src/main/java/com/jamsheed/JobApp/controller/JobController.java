package com.jamsheed.JobApp.controller;

import com.jamsheed.JobApp.model.Job;
import com.jamsheed.JobApp.model.JobType;
import com.jamsheed.JobApp.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
public class JobController {
    @Autowired
    JobService jobService;

    @PostMapping("Jobs")
    public String addJobs(@RequestBody @Valid List<Job> newjobs){
     return    jobService.addJobs(newjobs);
    }


    @GetMapping("Jobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PutMapping("job/employeename/id/{id}")
    public String updateJobById(@PathVariable @Valid Long id, @RequestParam  String name){
        return jobService. updateJobById(id,name);
    }

    @DeleteMapping("Jobs/ids")
    public String deleteJobsBYIds(@RequestBody @Valid List<Long> ids){
        return jobService.deleteJobsBYIds(ids);
    }


    // Custom finders
    @GetMapping("jobs/type/{jobType}")
    public List<Job> getAllJobsOfType(@PathVariable JobType jobType){
      return   jobService.getAllJobsOfType(jobType);
    }


    @GetMapping("jobs/type/{jobType}/salary/{salary}")
    public List<Job>getAllJobsOfTypeAndSalaryGreaterEqual(@PathVariable JobType jobType,@PathVariable @Valid Double salary){
        return   jobService.getAllJobsOfTypeAndSalaryGreaterEqual(jobType,salary);
    }

    @GetMapping("jobs/location/{location}/salary/{salary}")
    public List<Job>getAllJobsByLocationAndSalaryGreaterEqual(@PathVariable String location,@PathVariable @Valid Double salary){
        return   jobService.getAllJobsByLocationAndSalaryGreaterEqual(location,salary);
    }


    @GetMapping("jobs/type/{jobType}/location/{location}/date/{appiliedDate}")
    public List<Job>getAllJobsOfTypeByLocationAndDate(@PathVariable JobType jobType,@PathVariable String location,@PathVariable LocalDate appiliedDate){
        return   jobService.getAllJobsOfTypeByLocationAndDate(jobType,location,appiliedDate);
    }



    //Custom Queries

   @PutMapping("job/{percentHike}/employerName/{employerName}")
    public String updateSalaryByEmployerName(@PathVariable float percentHike, @PathVariable String employerName ){
        return jobService.updateSalaryByEmployerName(percentHike,employerName);
   }



    @PutMapping("job/{percentHike}/jobType/{jobType}")
    public String updateSalaryByJobType(@PathVariable float percentHike, @PathVariable JobType jobType ){
        return jobService.updateSalaryByJobType(percentHike,jobType);
    }



    @DeleteMapping("job/employerName/{employerName}")
    public String deleteByEmployerName(@PathVariable String employerName){
        return jobService.deleteByEmployerName(employerName);
    }


    @DeleteMapping("job/location/{location}/employerName/{employerName}/jobTYpe/{jobType}")
    public String deleteByLocation(@PathVariable String location,@PathVariable String employerName,@PathVariable JobType jobType){
        return jobService.deleteByLocation(location,employerName,jobType);
    }
}
