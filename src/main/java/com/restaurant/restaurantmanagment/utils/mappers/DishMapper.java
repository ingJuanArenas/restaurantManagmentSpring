package com.restaurant.restaurantmanagment.utils.mappers;

import org.mapstruct.Mapper;

import com.restaurant.restaurantmanagment.model.dto.request.DishRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.DishResponse;
import com.restaurant.restaurantmanagment.model.vo.Dish;

@Mapper(componentModel = "spring")
public interface DishMapper {
    Dish toEntity(DishRequest request);
    DishResponse toResponse(Dish dish);
}
