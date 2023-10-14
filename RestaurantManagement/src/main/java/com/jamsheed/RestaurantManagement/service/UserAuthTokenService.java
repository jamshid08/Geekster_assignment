package com.jamsheed.RestaurantManagement.service;

import com.jamsheed.RestaurantManagement.model.UserAuthToken;
import com.jamsheed.RestaurantManagement.model.dto.AuthenticationInputDto;
import com.jamsheed.RestaurantManagement.repo.IUserAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthTokenService {

    @Autowired
    IUserAuthTokenRepo userAuthTokenRepo;

    public void createToken(UserAuthToken token) {

        userAuthTokenRepo.save(token);

    }

    public boolean isAuthenticated(AuthenticationInputDto authInfo) {
        String email = authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();

        UserAuthToken token = userAuthTokenRepo.findFirstByTokenValue(tokenValue);

        if(token != null) {
            return token.getUser().getEmail().equals(email);
        }

        return false;
    }

    public void deleteToken(String tokenValue) {

            UserAuthToken token = userAuthTokenRepo.findFirstByTokenValue(tokenValue);
             userAuthTokenRepo.delete(token);
    }
}
