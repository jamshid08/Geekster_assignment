package com.jamsheed.RestaurantManagement.repo;

import com.jamsheed.RestaurantManagement.model.UserAuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAuthTokenRepo extends JpaRepository<UserAuthToken,Integer> {
    UserAuthToken findFirstByTokenValue(String tokenValue);
}
