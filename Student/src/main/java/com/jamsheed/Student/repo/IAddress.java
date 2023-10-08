package com.jamsheed.Student.repo;

import com.jamsheed.Student.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddress extends JpaRepository<Address,Long> {
}
