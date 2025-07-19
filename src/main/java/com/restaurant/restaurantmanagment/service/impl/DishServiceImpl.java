package com.restaurant.restaurantmanagment.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.restaurantmanagment.exceptions.AlreadyExistException;
import com.restaurant.restaurantmanagment.exceptions.NotFoundException;
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
        var dishes = dr.getAllByName("%" + name + "%");
        if (dishes.isEmpty()) {
            throw new NotFoundException("No se encuentra ningun plato con el nombre: "+ name);
        }

         return dishes.stream().map(dm::toResponse).toList();
    }

    @Override
    public DishResponse saveNew(DishRequest rq) {
        var entity= dm.toEntity(rq);
        var search = dr.existsByName(entity.getName());
        if (search) { throw new AlreadyExistException("El plato ya esta registrado"); }
        
        var newDish = dr.save(entity);

        return dm.toResponse(newDish);
    }

    @Override
    public void delete(Long id) {
    
        var entity = dr.findById(id).orElseThrow(() -> new NotFoundException("El plato con id: "+id+" no existe"));
        dr.delete(entity);

    }



}