package com.jamsheed.RestaurantManagement.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OrderTable")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Order.class,property = "orderId")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
     @JoinColumn(name = "fk_user_id")
    User user;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
    List<FoodItem> foodItemList;

}
