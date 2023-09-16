package com.Jamsheed.UserManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class User_API {
    @Autowired
    List<User> user_list;


    @PostMapping("user")
    public String addUser(@RequestBody User newUser) {
        user_list.add(newUser);
        return "New User added";
    }


    @GetMapping("user/all")
    public List<User> getAllusers() {

        return user_list;
    }


    @PutMapping("user/id/{id}")
    public String setUserInfoById(@PathVariable Integer id, @RequestBody User update_user) {
        for (User user : user_list) {
            if (user.getUserId().equals(id)) {
                user.setName(update_user.getName());
                user.setUserName(update_user.getUserName());
                user.setPhoneNumber(update_user.getPhoneNumber());
                user.setAddress(update_user.getAddress());
                return "user Info Upadated";
            }
        }

        return "Invalid id";
    }

    @DeleteMapping("user/id/{id}/delete")
    public String removeUserById(@PathVariable Integer id) {
        for (User user : user_list) {
            if (user.getUserId().equals(id)) {
                user_list.remove(user);
                return "user: " + id + " deleted";
            }
        }

        return "Invalid id";
    }


    @GetMapping("user/userid/{id}")
    public Object getUserInfoById(@PathVariable Integer id) {
        for (User user : user_list) {
            if (user.getUserId().equals(id)) {

                return user;
            }
        }

        String str = "invalid id";
        Object ob = str;
        return  ob;
    }
}
