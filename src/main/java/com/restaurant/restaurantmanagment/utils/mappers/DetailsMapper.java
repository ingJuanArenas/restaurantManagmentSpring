package com.restaurant.restaurantmanagment.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.restaurant.restaurantmanagment.model.dto.request.OrderDetailRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.OrderDetailResponse;
import com.restaurant.restaurantmanagment.model.vo.OrderDetail;

@Mapper(componentModel = "spring")
public interface DetailsMapper {
    OrderDetail toEntity(OrderDetailRequest request);
    OrderDetailResponse toResponse(OrderDetail details);
    List<OrderDetail> toEntity(List<OrderDetailRequest> requestList); // <== importante
    List<OrderDetailResponse> toResponse(List<OrderDetail> entityList);
}

