package com.restaurant.restaurantmanagment.model.dto.responses;



import lombok.Data;

@Data
public class TableResponse {
    private Long id;
    private Integer seats;
    private Boolean avaliable;
}
