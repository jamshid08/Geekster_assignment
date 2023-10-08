package com.jamsheed.Student.repo;

import com.jamsheed.Student.model.Address;
import com.jamsheed.Student.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaptop extends JpaRepository<Laptop,String> {
}
