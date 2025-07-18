package com.restaurant.restaurantmanagment.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.restaurantmanagment.model.dto.request.DishRequest;
import com.restaurant.restaurantmanagment.model.dto.responses.DishResponse;
import com.restaurant.restaurantmanagment.model.vo.Dish;
import com.restaurant.restaurantmanagment.repository.DishRepository;
import com.restaurant.restaurantmanagment.service.ServiceDAO;
import com.restaurant.restaurantmanagment.utils.mappers.DishMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DishServiceImpl extends ServiceDAO <Dish,DishRequest,DishResponse> {

    private final DishRepository dr;
    private final DishMapper dm;
    @Override
    public List<DishResponse> getAll() {
        return dr.findAll().stream().map(dm::toResponse).toList();
    }

    @Override
    public List<DishResponse> get(String name) {
        return dr.getAllByName('%'+name+'%').stream().map(dm::toResponse).toList();
    }

    @Override
    public DishResponse saveNew(DishRequest rq) {
        var entity= dm.toEntity(rq);
        var newDish = dr.save(entity);

        return dm.toResponse(newDish);
    }

    @Override
    public void delete(Long id) {
        dr.deleteById(id);
    }



}