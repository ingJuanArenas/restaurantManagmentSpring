package com.restaurant.restaurantmanagment.model.dto.responses;


import lombok.Data;

@Data
public class DishResponse {
    private Long id;
    private String name;
    private Double price;
    private Boolean available;
}
