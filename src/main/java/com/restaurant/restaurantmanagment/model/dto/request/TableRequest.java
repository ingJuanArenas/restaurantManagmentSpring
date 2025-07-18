package com.restaurant.restaurantmanagment.model.dto.request;



import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TableRequest {

    @NotNull
    private int seats;
    @NotNull
    private boolean available;
}

