package com.jamsheed.UserManagementSystem_Validation.controller;

import com.jamsheed.UserManagementSystem_Validation.model.User;
import com.jamsheed.UserManagementSystem_Validation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;

    // add a list of user, with this we also add a single user(list with single user)

    @PostMapping("users")
    public String addUsers(@RequestBody @Valid List<User> newUserList){
      return   userService.addUsers(newUserList);
    }

    
    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("user/id/{id}")
    public Object getUserById(@PathVariable @Valid Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("user/id/{id}")
    public String deleteUserById(@PathVariable @Valid Long id){
        return userService.deleteUserById(id);
    }


    @PutMapping("user/id/{id}")
    public String updateUserById(@PathVariable @Valid Long id, @RequestBody @Valid User updateUser){
        return userService.updateUserById(id,updateUser);
    }
        


}
