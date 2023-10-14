package com.jamsheed.RestaurantManagement.controller;

import com.jamsheed.RestaurantManagement.model.FoodItem;
import com.jamsheed.RestaurantManagement.model.User;
import com.jamsheed.RestaurantManagement.model.dto.AuthenticationInputDto;
import com.jamsheed.RestaurantManagement.model.dto.CreateOrderDto;
import com.jamsheed.RestaurantManagement.model.dto.SignInDto;
import com.jamsheed.RestaurantManagement.service.FoodIteamService;
import com.jamsheed.RestaurantManagement.service.OrderService;
import com.jamsheed.RestaurantManagement.service.UserService;
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

    @Autowired
    OrderService orderService;



    @PostMapping("user/signup")
    public String userSignUp(@Valid @RequestBody User user)
    {
        return userService.userSignUp(user);

    }

    @PostMapping("user/signIn")
    public String userSignIn(@Valid  @RequestBody SignInDto signInInput)
    {
        return userService.userSignIn(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String userSignOut(@RequestBody AuthenticationInputDto authInfo)
    {
        return userService.userSignOut(authInfo);
    }

//  get all food items any user can see no need for authentication

   @GetMapping("foodItems")
    public List<FoodItem> getAllFoodItems(){
        return userService.getAllFoodItems();

    }

// only authenticated user can order and cancel order
    @PostMapping("order")
    public String CreateOrder(@RequestBody @Valid CreateOrderDto newOrder){
      return   orderService.CreateOrder(newOrder.getAuthenticationInputDto(), newOrder.getOrder());
    }

    @PutMapping("cancel/order/{orderId}")
    public String cancelOrder(@PathVariable @Valid Integer orderId, @RequestBody @Valid AuthenticationInputDto authenticationInputDto){
        return orderService.cancelOrder(orderId,authenticationInputDto);
    }


}
