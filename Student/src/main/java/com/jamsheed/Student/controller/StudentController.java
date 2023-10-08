package com.jamsheed.Student.controller;

import com.jamsheed.Student.model.Student;
import com.jamsheed.Student.model.Student;
import com.jamsheed.Student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("Student")
    public String addStudent(@RequestBody @Valid Student newStudent){

        return studentService.addStudent(newStudent);
    }

    @PutMapping("student/id/{id}")
    public String updateStudentById(@PathVariable @Valid String id, @RequestBody @Valid  Student updateStudent){
        return studentService.updateStudentById(id, updateStudent);
    }

    @DeleteMapping("student/id/{id}")
    public String deleteById(@PathVariable @Valid String  id){
        return studentService.deleteById(id);
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @GetMapping("student/id/{id}")
    public Student getStudentById(@PathVariable @Valid String  id){
        return studentService.getStudentById(id);
    }
}
