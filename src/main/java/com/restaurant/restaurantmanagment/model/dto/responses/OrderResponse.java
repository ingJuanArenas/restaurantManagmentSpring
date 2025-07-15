package com.restaurant.restaurantmanagment.model.dto.responses;


import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private TableResponse table;
    private List<OrderDetailResponse> details;
    private Double total;
}
