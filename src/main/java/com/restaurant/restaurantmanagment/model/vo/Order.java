package com.restaurant.restaurantmanagment.model.vo;

import java.time.LocalDate;
import java.util.List;

public class Order {
    Long id;
Long tableId; 
LocalDate date; 
Double total; 
List<OrderDetail> details; 

}
