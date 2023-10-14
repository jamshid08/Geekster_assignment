package com.jamsheed.RestaurantManagement.repo;

import com.jamsheed.RestaurantManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByEmail(String newEmail);


}
