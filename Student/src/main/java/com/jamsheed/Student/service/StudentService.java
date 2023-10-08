package com.jamsheed.Student.service;


import com.jamsheed.Student.model.Student;
import com.jamsheed.Student.repo.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    IStudent studentRepo;

    public String addStudent(Student newStudent) {
        studentRepo.save(newStudent);

        return "student added";
    }

    public String updateStudentById(String id, Student updateStudent) {
        studentRepo.findById(id).orElseThrow();
        studentRepo.save(updateStudent);
        return "student with ID: "+id+"  updated";
    }

    public String deleteById(String id) {
        studentRepo.findById(id).orElseThrow();
        studentRepo.deleteById(id);
        return "student with ID: "+id+"  deleted";
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(String id) {
        return  studentRepo.findById(id).orElseThrow();
    }
}
