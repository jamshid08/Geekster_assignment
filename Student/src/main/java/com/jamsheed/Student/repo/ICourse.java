package com.jamsheed.Student.repo;

import com.jamsheed.Student.model.Address;
import com.jamsheed.Student.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourse extends JpaRepository<Course,String> {
}
