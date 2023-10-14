package com.jamsheed.RestaurantManagement.model.dto;

import com.jamsheed.RestaurantManagement.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDto {

    AuthenticationInputDto authenticationInputDto;
    Order order;
}
