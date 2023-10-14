package com.jamsheed.RestaurantManagement.repo;

import com.jamsheed.RestaurantManagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order,Integer> {
}
