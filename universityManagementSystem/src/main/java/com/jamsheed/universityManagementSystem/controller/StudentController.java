package com.jamsheed.universityManagementSystem.controller;

import com.jamsheed.universityManagementSystem.model.Department;
import com.jamsheed.universityManagementSystem.model.Student;
import com.jamsheed.universityManagementSystem.service.StudentService;
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

    @PostMapping("students")
    public String addStudents(@RequestBody @Valid List<Student> newStudent){
        return studentService.addStudents(newStudent);

    }


    @PutMapping("student/id/{id}")
    public String updateStudentById(@PathVariable @Valid Integer id,@RequestParam @Valid Department department){
        return studentService.updateStudentById(id,department);
    }

    @DeleteMapping("student/id/{id}")
    public String deleteStudentById(@PathVariable @Valid Integer id){
        return studentService.deleteStudentById(id);
    }


    @GetMapping("students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @GetMapping("student/id/{id}")
    public Object getStudentById(@PathVariable @Valid Integer id){
        return studentService.getStudentById(id);
    }
}
