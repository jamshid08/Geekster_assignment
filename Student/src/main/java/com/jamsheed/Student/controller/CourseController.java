package com.jamsheed.Student.controller;

import com.jamsheed.Student.model.Book;
import com.jamsheed.Student.model.Course;
import com.jamsheed.Student.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("course")
    public String addCourse(@RequestBody @Valid Course newCourse){

        return courseService.addCourse(newCourse);
    }

    @PutMapping("course/id/{id}")
    public String updateCourseById(@PathVariable @Valid String id, @RequestBody @Valid  Course updateCourse){
        return courseService.updateCourseById(id, updateCourse);
    }

    @DeleteMapping("course/id/{id}")
    public String deleteById(@PathVariable @Valid String  id){
        return courseService.deleteById(id);
    }

    @GetMapping("Courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }


    @GetMapping("course/id/{id}")
    public Course getCourseById(@PathVariable @Valid String  id){
        return courseService.getCourseById(id);
    }
}
