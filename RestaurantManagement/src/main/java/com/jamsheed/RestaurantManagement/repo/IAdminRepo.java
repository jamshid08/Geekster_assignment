package com.jamsheed.RestaurantManagement.repo;

import com.jamsheed.RestaurantManagement.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Integer> {
}
