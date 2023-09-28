package com.jamsheed.universityManagementSystem.service;

import com.jamsheed.universityManagementSystem.model.Department;
import com.jamsheed.universityManagementSystem.model.Student;
import com.jamsheed.universityManagementSystem.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public String addStudents(List<Student> newStudent) {
        studentRepo.saveAll(newStudent);
        return newStudent.size()+"  students added";
    }

    public String updateStudentById(Integer id, Department department) {
        Student presentStudent = studentRepo.findById(id).orElse(null);

        if(presentStudent != null){
            presentStudent.setDepartment(department);
            studentRepo.save(presentStudent);
            return "student Department updated to : "+ department;
        }

        return "Student Not found with given ID :"+ id;
    }

    public String deleteStudentById(Integer id) {
        Student presentStudent = studentRepo.findById(id).orElse(null);

        if(presentStudent != null){
            studentRepo.delete(presentStudent);
            return "student with ID: "+id+" deleted";
        }

        return "Student Not found with given ID :"+ id;

    }


    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Object getStudentById(Integer id) {

        Student presentStudent = studentRepo.findById(id).orElse(null);

        if(presentStudent != null){
          return   presentStudent;

        }

        Object ob = "Student Not found with given ID :"+ id;

        return ob;

    }
}
