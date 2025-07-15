package com.restaurant.restaurantmanagment.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderDetailRequest {
    @NotNull
    private Long dishId;

    @NotNull
    @Min(1)
    private Integer quantity;
}

