package com.jamsheed.JobApp.repo;

import com.jamsheed.JobApp.model.Job;
import com.jamsheed.JobApp.model.JobType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface IJobRepo extends CrudRepository<Job,Long>{

    List<Job> findByJobType(JobType jobType);

    List<Job> findByJobTypeAndSalaryGreaterThanEqualOrderBySalaryDesc(JobType jobType, Double salary);

    List<Job> findByLocationAndSalaryGreaterThan(String location, Double salary);


    List<Job> findByJobTypeAndLocationAndAppliedDateAfterOrderBySalaryDesc(JobType jobType, String location, LocalDate appiliedDate);
    @Modifying
    @Query(value = "UPDATE  JOB_SEARCH  SET SALARY = (SALARY  + SALARY *(:percentHike)) WHERE EMPLOYER_NAME = :employerName", nativeQuery = true)
    void updateSalaryByEmployerName(float percentHike, String employerName);
    @Modifying
    @Query(value = "UPDATE  JOB_SEARCH  SET SALARY = (SALARY  + SALARY *(:percentHike)) WHERE JOB_TYPE = :jobType", nativeQuery = true)
    void updateSalaryByJobType(float percentHike, String jobType);
    @Modifying
    @Query(value = "DELETE FROM  JOB_SEARCH  WHERE EMPLOYER_NAME= :employerName", nativeQuery = true)
    void deleteByEmployerName(String employerName);
    @Modifying
    @Query(value = "DELETE FROM  JOB_SEARCH  WHERE LOCATION= :location AND EMPLOYER_NAME= :employerName AND  JOB_TYPE = :jobType", nativeQuery = true)
    void deleteByLocation(String location, String employerName,String jobType);
}
