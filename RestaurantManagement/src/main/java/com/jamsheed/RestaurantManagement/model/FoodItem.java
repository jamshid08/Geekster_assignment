package com.jamsheed.RestaurantManagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.persister.collection.mutation.InsertRowsCoordinatorTablePerSubclass;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = FoodItem.class,property = "foodItemId")
public class FoodItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Integer foodItemId;
   String foodItemName;
   String foodItemDescription;
   String foodItemPrice;

   @ManyToOne
   @JoinColumn(name = "fk_order_id")
   Order order;


}
