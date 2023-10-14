package com.jamsheed.RestaurantManagement.service;

import com.jamsheed.RestaurantManagement.model.FoodItem;
import com.jamsheed.RestaurantManagement.model.Order;
import com.jamsheed.RestaurantManagement.model.User;
import com.jamsheed.RestaurantManagement.model.dto.AuthenticationInputDto;
import com.jamsheed.RestaurantManagement.repo.IFoodIteamRepo;
import com.jamsheed.RestaurantManagement.repo.IOrderRepo;
import com.jamsheed.RestaurantManagement.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.jamsheed.RestaurantManagement.model.Status.cancelled;
import static com.jamsheed.RestaurantManagement.model.Status.created;

@Service
public class OrderService {

    @Autowired
    UserAuthTokenService userAuthTokenService;
    @Autowired
    IUserRepo userRepo;
    @Autowired
    IOrderRepo orderRepo;
    @Autowired
    IFoodIteamRepo foodIteamRepo;

    public String CreateOrder(AuthenticationInputDto authenticationInputDto, Order order) {

        if(userAuthTokenService.isAuthenticated(authenticationInputDto)){
       String email = authenticationInputDto.getEmail();
            User user = userRepo.findFirstByEmail(email);
          order.setUser(user);
          order.setStatus(created);
// linking with order from non Fk side
          for(FoodItem foodItem : order.getFoodItemList()){
              Integer foodItemId = foodItem.getFoodItemId();

              FoodItem item = foodIteamRepo.findById(foodItemId).orElseThrow();


                  foodItem.setOrder(order);
                      }

         orderRepo.save(order);

          return "Order has been created";
          }



        else {
            return "Un Authenticated access!!!";
        }
    }

    public String cancelOrder(Integer orderId, AuthenticationInputDto authenticationInputDto) {
        if (userAuthTokenService.isAuthenticated(authenticationInputDto)) {
            String email = authenticationInputDto.getEmail();
            User user = userRepo.findFirstByEmail(email);
            Order order = orderRepo.findById(orderId).orElseThrow();
            User user1 = order.getUser();
            if (user1 != null) {
                if (user.equals(user1)) {
                    order.setStatus(cancelled);
                    orderRepo.save(order);
                    return " order cancelled";
                } else {
                    return "un authorised access";
                }
            } else {
                return "un authorised access";
            }

        } else {
            return "Un Authenticated access!!!";
        }


    }
}
