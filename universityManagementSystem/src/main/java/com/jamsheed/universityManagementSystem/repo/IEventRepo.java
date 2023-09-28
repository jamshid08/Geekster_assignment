package com.jamsheed.universityManagementSystem.repo;

import com.jamsheed.universityManagementSystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IEventRepo extends JpaRepository<Event,Integer> {
    List<Event> findByDate(LocalDate date);
}
