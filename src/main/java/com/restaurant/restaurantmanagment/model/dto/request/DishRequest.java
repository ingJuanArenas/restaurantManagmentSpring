package com.restaurant.restaurantmanagment.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class DishRequest {
    @NotBlank
    private String name;
    
    @NotNull
    @Positive
    private Double price;

    private Boolean available;
}

