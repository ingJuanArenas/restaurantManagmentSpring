package com.restaurant.restaurantmanagment.model.dto.responses;


import lombok.Data;

@Data
public class OrderDetailResponse {
    private Long id;
    private DishResponse dish;
    private Integer quantity;
    private Double subtotal;
}
