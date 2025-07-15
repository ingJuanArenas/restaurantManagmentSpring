package com.restaurant.restaurantmanagment.model.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    @NotNull
    private Long tableId;

    @NotNull
    private List<OrderDetailRequest> details;
}
