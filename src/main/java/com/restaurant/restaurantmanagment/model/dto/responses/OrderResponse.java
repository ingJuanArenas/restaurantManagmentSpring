package com.restaurant.restaurantmanagment.model.dto.responses;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;



@Data
public class OrderResponse {
    private Long id;
    private Long tableId;
    private LocalDate date;
    private Double total;
    private List<OrderDetailResponse> details;
}

