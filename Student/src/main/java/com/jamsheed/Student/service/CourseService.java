package com.jamsheed.Student.service;

import com.jamsheed.Student.model.Course;
import com.jamsheed.Student.repo.ICourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    ICourse courseRepo;

    public String addCourse(Course newCourse) {
        courseRepo.save(newCourse);
        return "course added";
    }

    public String updateCourseById(String id, Course updateCourse) {
        courseRepo.findById(id).orElseThrow();
        courseRepo.save(updateCourse);
        return "course with ID : "+ id+"  updated";
    }

    public String deleteById(String id) {
        courseRepo.findById(id).orElseThrow();
        courseRepo.deleteById(id);
        return "Course with ID: "+id+ " deleted";
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course getCourseById(String id) {
        return  courseRepo.findById(id).orElseThrow();
    }
}
