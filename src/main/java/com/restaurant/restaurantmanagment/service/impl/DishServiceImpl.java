package com.restaurant.restaurantmanagment.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.restaurantmanagment.model.dto.request.DishRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.DishResponse;
import com.restaurant.restaurantmanagment.model.vo.Dish;
import com.restaurant.restaurantmanagment.repository.DishRepository;
import com.restaurant.restaurantmanagment.service.ServiceDAO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DishServiceImpl extends ServiceDAO <Dish,DishRequest,DishResponse> {

    private final DishRepository dr;

    @Override
    public List<DishResponse> getAllDishes() {
        return dr.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public List<DishResponse> getDish(String name) {
        return dr.getAllByName('%'+name+'%').stream().map(this::toResponse).toList();
    }

    @Override
    public DishResponse saveNewDish(DishRequest rq) {
        var entity= toEntity(rq);
        var newDish = dr.save(entity);

        return toResponse(newDish);
    }

    @Override
    public void deleteDish(Long id) {
        dr.deleteById(id);
    }

    @Override
    public DishResponse toResponse(Dish dish) {
        var response = new DishResponse();
        response.setId(dish.getId());
        response.setName(dish.getName());
        response.setPrice(dish.getPrice());
        response.setAvailable(dish.getAvailable());
        return response;
    }

    @Override
    public Dish toEntity(DishRequest rq) {
        var entity = new Dish();
        entity.setName(rq.getName());
        entity.setPrice(rq.getPrice());
        entity.setAvailable(rq.getAvailable());
        return entity;
    }

}