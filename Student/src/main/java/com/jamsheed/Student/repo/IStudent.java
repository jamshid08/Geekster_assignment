package com.jamsheed.Student.repo;

import com.jamsheed.Student.model.Address;
import com.jamsheed.Student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudent extends JpaRepository<Student,String> {
}
