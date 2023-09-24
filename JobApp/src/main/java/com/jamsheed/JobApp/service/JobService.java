package com.jamsheed.JobApp.service;

import com.jamsheed.JobApp.model.Job;
import com.jamsheed.JobApp.model.JobType;
import com.jamsheed.JobApp.repo.IJobRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobService {
    @Autowired
    IJobRepo jobRepo ;

    public String addJobs(List<Job> newjobs) {
        jobRepo.saveAll(newjobs);

       return newjobs.size() +" "+ "Added";
    }

    public List<Job> getAllJobs() {
      return (List<Job>) jobRepo.findAll();
    }

    public String updateJobById(Long id, String name) {
   Job parentJob = (Job) jobRepo.findById(id).orElse(null);

   if(parentJob != null){
      parentJob.setEmployerName(name);
      jobRepo.save(parentJob);
      return "employee name updated to : "+ name;
   }

return "Job Not found with given ID :"+ id;
    }

    public String deleteJobsBYIds(List<Long> ids) {
        jobRepo.deleteAllById(ids);
        return ids.size()+"  Jobs deleted";
    }

    public List<Job> getAllJobsOfType(JobType jobType) {
        return jobRepo.findByJobType(jobType);
    }

    public List<Job> getAllJobsOfTypeAndSalaryGreaterEqual(JobType jobType, Double salary) {
        return jobRepo.findByJobTypeAndSalaryGreaterThanEqualOrderBySalaryDesc(jobType,salary);
    }

    public List<Job> getAllJobsByLocationAndSalaryGreaterEqual(String location, Double salary) {

        return jobRepo.findByLocationAndSalaryGreaterThan(location,salary);
    }

    public List<Job> getAllJobsOfTypeByLocationAndDate(JobType jobType, String location, LocalDate appiliedDate) {

        return jobRepo.findByJobTypeAndLocationAndAppliedDateAfterOrderBySalaryDesc(jobType,location,appiliedDate);
    }
@Transactional
    public String updateSalaryByEmployerName(float percentHike, String employerName) {
                 jobRepo. updateSalaryByEmployerName(percentHike,employerName);
                 return "salary updated";
    }
    @Transactional
    public String updateSalaryByJobType(float percentHike, JobType jobType) {
        jobRepo.updateSalaryByJobType(percentHike, jobType.name());
        return "updated salary for "+jobType;
    }
@Transactional
    public String deleteByEmployerName(String employerName) {
        jobRepo.deleteByEmployerName(employerName);
        return "record deleted with employerName: "+employerName;
    }
@Transactional
    public String deleteByLocation(String location, String employerName,JobType jobType) {
        jobRepo.deleteByLocation(location, employerName,jobType.name());
        return "record deleted with location: "+location+", employerName: "+employerName+" and department: "+jobType;
    }
}
