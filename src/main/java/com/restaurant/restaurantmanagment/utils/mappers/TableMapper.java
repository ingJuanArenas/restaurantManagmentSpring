package com.restaurant.restaurantmanagment.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.restaurant.restaurantmanagment.model.dto.request.TableRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.TableResponse;
import com.restaurant.restaurantmanagment.model.vo.RestaurantTable;



@Mapper(componentModel = "spring")
public interface TableMapper {
    RestaurantTable toEntity(TableRequest request);
    TableResponse toResponse(RestaurantTable restaurantTable);
}
