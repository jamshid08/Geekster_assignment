package com.jamsheed.UserManagementSystem_Validation.service;

import com.jamsheed.UserManagementSystem_Validation.model.User;
import com.jamsheed.UserManagementSystem_Validation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
    UserRepo userRepo;


    public String addUsers(List<User> newUserList) {
        userRepo.getUserList().addAll(newUserList);
        return newUserList.size() +" users added";
    }

    public List<User> getAllUsers() {
       return userRepo.getUserList();
    }

    public Object getUserById(Long id) {
        for (User user : userRepo.getUserList()) {
            if (user.getUserId().equals(id)) {

                return user;
            }
        }

       // String str = "invalid id";
        Object ob ="invalid id";;
        return  ob;
    }

    public String deleteUserById(Long id) {
        for (User user : userRepo.getUserList()) {
            if (user.getUserId().equals(id)) {

            userRepo.getUserList().remove(user);
            return "user with ID : "+user.getUserId()+" deleted";
            }
        }


      return   "invalid id";


    }

    public String updateUserById(Long id, User updateUser) {
        for (User user : userRepo.getUserList()) {
            if (user.getUserId().equals(id)) {
                user.setUsername(updateUser.getUsername());
                user.setDateOfBirth(updateUser.getDateOfBirth());
                user.setEmail(updateUser.getEmail());
                user.setPhoneNumber(updateUser.getPhoneNumber());
                return "user with ID : "+id+" Info has Upadated";
            }
        }

        return "Invalid id";
    }
}
