package com.jamsheed.RestaurantManagement.service;

import com.jamsheed.RestaurantManagement.model.FoodItem;
import com.jamsheed.RestaurantManagement.model.User;
import com.jamsheed.RestaurantManagement.model.UserAuthToken;
import com.jamsheed.RestaurantManagement.model.dto.AuthenticationInputDto;
import com.jamsheed.RestaurantManagement.model.dto.SignInDto;
import com.jamsheed.RestaurantManagement.repo.IUserAuthTokenRepo;
import com.jamsheed.RestaurantManagement.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserAuthTokenService userAuthTokenService;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    FoodIteamService foodIteamService;

    public String userSignUp(User user) {

        String newEmail = user.getEmail();
        User existingUser = userRepo.findFirstByEmail(newEmail);

        if(existingUser != null) {
            return "email already in use";
        }


        String signUpPassword = user.getPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(signUpPassword);

            user.setPassword(encryptedPassword);



            userRepo.save(user);
            return "User registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }


    }

    public String userSignIn(SignInDto signInInput) {
         String email = signInInput.getEmail();
         User existingUser =  userRepo.findFirstByEmail(email);

        if(existingUser == null)
        {
            return "Not a valid email, Please sign up first !!!";
        }



        String password = signInInput.getPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if(existingUser.getPassword().equals(encryptedPassword))
            {
                UserAuthToken token  = new UserAuthToken(existingUser);

                if(EmailService.sendEmail(email,"Token after login", token.getTokenValue())) {
                    userAuthTokenService.createToken(token);
                    return "check email for otp/token!!!";
                }
                else {
                    return "error while generating token!!!";
                }

            }
            else {
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }

    public String userSignOut(AuthenticationInputDto authInfo) {
        if(userAuthTokenService.isAuthenticated(authInfo)){
            String tokenValue = authInfo.getTokenValue();
            userAuthTokenService.deleteToken(tokenValue);
            return "Sign out successfully";
        }

        else{
            return "Un Authenticated access!!!";
        }

    }

    public List<FoodItem> getAllFoodItems() {

      return   foodIteamService. getAllFoodItems();
    }
}
