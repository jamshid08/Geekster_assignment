package com.jamsheed.universityManagementSystem.repo;

import com.jamsheed.universityManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student,Integer> {
}
